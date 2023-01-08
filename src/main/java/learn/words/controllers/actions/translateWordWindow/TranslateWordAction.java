package learn.words.controllers.actions.translateWordWindow;

import learn.words.controllers.actions.AbstractAction;
import learn.words.controllers.translator.TranslateWord;
import learn.words.views.options.buttonOptions.UseBothTextFieldsButtonOptions;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TranslateWordAction implements AbstractAction {
    private final UseBothTextFieldsButtonOptions options;
    public TranslateWordAction(UseBothTextFieldsButtonOptions options) {
        this.options = options;
    }

    @Override
    public void executeCommand() {
        String word = getInputTextFieldValue();
        if (word.equals("")) {
            System.out.println(1);
            setDisabledTextFieldValue("Введите слово");
        } else {
            tryToTranslateWord(word);
        }
    }

    private void tryToTranslateWord(String text) {
        try {
            translateWordInNewThread(text);
        } catch (ExecutionException | InterruptedException e) {
            setDisabledTextFieldValue("Что то пошло не так, попробуйте снова");
        }
    }

    private void translateWordInNewThread(String text) throws ExecutionException, InterruptedException {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                List<String> translatedTexts = translateText(text);

                if (translatedTexts.isEmpty()) {
                    setDisabledTextFieldValue("Перевод не найден");
                } else {
                    setMainFrameTranslatedWordList(translatedTexts);
                    setDisabledTextFieldValue(translatedTexts.get(0));
                    setWordToTranslate(text);
                }
                return null;
            }
        };
        worker.execute();
    }

    private String getInputTextFieldValue() {
        return options.getInputTextField().getText();
    }

    private List<String> translateText(String text) {
        TranslateWord translatedText = new TranslateWord(text);
        return translatedText.doTranslate();
    }

    private void setDisabledTextFieldValue(String translatedTexts) {
        options.getDisabledTextField().setText(translatedTexts);
    }

    private void setMainFrameTranslatedWordList(List<String> translatedWordList) {
        options.getWindow().setTranslatedWords(translatedWordList);
    }

    private void setWordToTranslate(String text) {
        options.getWindow().setWordToTranslate(text);
    }
}

package learn.words.controller.action.translatewindowactions;

import learn.words.controller.action.ActionFactory;
import learn.words.controller.translator.TranslateWord;
import learn.words.view.option.GridButtonOptions;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TranslateButtonAction implements ActionFactory {
    private final GridButtonOptions options;
    public TranslateButtonAction(GridButtonOptions options) {
        this.options = options;
    }

    @Override
    public void executeCommand() {
        String word = getInputTextFieldValue();
        if (word.equals("")) {
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
        options.getTranslateWordWindow().setTranslatedWords(translatedWordList);
    }

    private void setWordToTranslate(String text) {
        options.getTranslateWordWindow().setWordToTranslate(text);
    }
}

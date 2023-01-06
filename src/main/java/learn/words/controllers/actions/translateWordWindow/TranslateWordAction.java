package learn.words.controllers.actions.translateWordWindow;

import learn.words.controllers.actions.AbstractAction;
import learn.words.controllers.translator.TranslateText;
import learn.words.views.options.buttonOptions.ChangeBothTextFieldsButtonOptions;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TranslateWordAction implements AbstractAction {
    private final ChangeBothTextFieldsButtonOptions options;
    public TranslateWordAction(ChangeBothTextFieldsButtonOptions options) {
        this.options = options;
    }

    @Override
    public void executeCommand() {
        String text = getInputTextFieldValue();
        if (text.equals("")) {
            System.out.println(1);
            setDisabledTextFieldValue("Введите слово");
        } else {
            tryToTranslateText(text);
        }
    }

    private void tryToTranslateText(String text) {
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
                    setTextToTranslate(text);
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
        TranslateText translatedText = new TranslateText(text);
        return translatedText.doTranslate();
    }

    private void setDisabledTextFieldValue(String translatedTexts) {
        options.getDisabledTextField().setText(translatedTexts);
    }

    private void setMainFrameTranslatedWordList(List<String> translatedWordList) {
        options.getWindow().setTranslatedWords(translatedWordList);
    }

    private void setTextToTranslate(String text) {
        options.getWindow().setTextToTranslate(text);
    }
}

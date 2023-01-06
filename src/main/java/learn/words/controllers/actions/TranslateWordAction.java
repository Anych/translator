package learn.words.controllers.actions;

import learn.words.controllers.translator.TranslateText;
import learn.words.views.options.buttonOptions.TranslateWordButtonOptions;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TranslateWordAction implements AbstractAction {
    private final TranslateWordButtonOptions options;
    private List<String> translatedTexts;

    public TranslateWordAction(TranslateWordButtonOptions options) {
        this.options = options;
    }

    @Override
    public void executeCommand() {
        String text = getInputTextFieldValue();
        tryToTranslateText(text);

        setMainFrameTranslatedWordList(translatedTexts);
        setDisabledTextFieldValue(translatedTexts.get(0));
        setTextToTranslate(text);
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
                translatedTexts = translateText(text);
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

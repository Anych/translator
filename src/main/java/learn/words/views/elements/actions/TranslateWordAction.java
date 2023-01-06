package learn.words.views.elements.actions;

import learn.words.controllers.translator.TranslateText;
import learn.words.views.options.buttonOptions.TranslateWordButtonOptions;

import javax.swing.*;
import java.util.concurrent.ExecutionException;

public class TranslateWordAction implements AbstractAction {
    private final TranslateWordButtonOptions options;

    public TranslateWordAction(TranslateWordButtonOptions options) {
        this.options = options;
    }

    @Override
    public void executeCommand() {
        String text = getInputTextFieldValue();
        tryToTranslateText(text);
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
                String translatedText = translateText(text);
                setDisabledTextFieldValue(translatedText);
                return null;
            }
        };
        worker.execute();
    }

    private String getInputTextFieldValue() {
        return options.getInputTextField().getText();
    }

    private String translateText(String text) {
        TranslateText translatedText = new TranslateText(text);
        return translatedText.doTranslate();
    }

    private void setDisabledTextFieldValue(String translatedText) {
        options.getDisabledTextField().setText(translatedText);
    }
}

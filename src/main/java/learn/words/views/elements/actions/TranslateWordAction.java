package learn.words.views.elements.actions;

import learn.words.controllers.translator.TranslateText;
import learn.words.views.options.buttonOptions.TranslateWordButtonOptions;

public class TranslateWordAction implements AbstractAction {
    private final TranslateWordButtonOptions options;

    public TranslateWordAction(TranslateWordButtonOptions options) {
        this.options = options;
    }

    @Override
    public void executeCommand() {
        String text = getInputTextFieldValue();
        String translatedText = translateText(text);
        setDisabledTextFieldValue(translatedText);
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

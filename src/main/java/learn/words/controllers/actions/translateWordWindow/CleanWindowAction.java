package learn.words.controllers.actions.translateWordWindow;

import learn.words.controllers.actions.AbstractAction;
import learn.words.views.options.buttonOptions.ChangeBothTextFieldsButtonOptions;

import java.util.ArrayList;

public class CleanWindowAction implements AbstractAction {
    private final ChangeBothTextFieldsButtonOptions options;

    public CleanWindowAction(ChangeBothTextFieldsButtonOptions options) {
        this.options = options;
    }
    @Override
    public void executeCommand() {
        cleanAllWindowFields();
    }

    private void cleanAllWindowFields() {
        cleanTextFields();
        cleanPreviousTranslationPair();
    }

    private void cleanTextFields() {
        cleanDisabledTextField();
        cleanInputTextField();
    }

    private void cleanDisabledTextField() {
        options.getDisabledTextField().setText("");
    }

    private void cleanInputTextField() {
        options.getInputTextField().setText("");
    }

    private void cleanPreviousTranslationPair() {
        cleanTranslatedTextList();
        cleanWordToTranslate();
    }

    private void cleanTranslatedTextList() {
        options.getWindow().setTranslatedWords(new ArrayList<>());
    }

    private void cleanWordToTranslate() {
        options.getWindow().setTextToTranslate("");
    }
}

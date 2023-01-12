package learn.words.controller.action.translatebuttons;

import learn.words.controller.action.ActionFactory;
import learn.words.view.option.GridButtonOptions;

import java.util.ArrayList;

public class CleanButtonAction implements ActionFactory {
    private final GridButtonOptions options;

    public CleanButtonAction(GridButtonOptions options) {
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
        cleanTranslatedTextField();
        cleanWordToTranslate();
    }

    private void cleanTranslatedTextField() {
        options.getTranslateWordWindow().setTranslatedWords(new ArrayList<>());
    }

    private void cleanWordToTranslate() {
        options.getTranslateWordWindow().setWordToTranslate("");
    }
}

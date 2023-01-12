package learn.words.controller.action.translate_word_window;

import learn.words.controller.action.ActionFactory;
import learn.words.view.option.buttonoption.GridButtonOptions;

import java.util.ArrayList;

public class CleanWindowAction implements ActionFactory {
    private final GridButtonOptions options;

    public CleanWindowAction(GridButtonOptions options) {
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

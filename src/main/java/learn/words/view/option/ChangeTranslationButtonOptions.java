package learn.words.view.option;

import learn.words.view.option.buttonoption.AbstractGridButtonOptions;
import learn.words.view.window.TranslateWordWindow;

import javax.swing.*;

public class ChangeTranslationButtonOptions extends AbstractGridButtonOptions {
    private final JTextField disabledTextField;
    private final TranslateWordWindow window;

    public ChangeTranslationButtonOptions(TranslateWordWindow window, JTextField disabledTextField,
                                          String buttonName, int gridX, int gridY) {
        super(buttonName, gridX, gridY);
        this.window = window;
        this.disabledTextField = disabledTextField;
    }

    public JTextField getDisabledTextField() {
        return disabledTextField;
    }
    public TranslateWordWindow getWindow() {
        return window;
    }
}

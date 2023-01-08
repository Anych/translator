package learn.words.views.options.buttonOptions;

import learn.words.views.windows.TranslateWordWindow;

import javax.swing.*;

public class UseBothTextFieldsButtonOptions extends AbstractGridButtonOptions {
    private final JTextField inputTextField;
    private final JTextField disabledTextField;
    private final TranslateWordWindow window;

    public UseBothTextFieldsButtonOptions(TranslateWordWindow window, JTextField inputTextField,
                                          JTextField disabledTextField, String buttonName, int gridX, int gridY) {
        super(buttonName, gridX, gridY);
        this.window = window;
        this.inputTextField = inputTextField;
        this.disabledTextField = disabledTextField;
    }

    public JTextField getInputTextField() {
        return inputTextField;
    }

    public JTextField getDisabledTextField() {
        return disabledTextField;
    }

    public TranslateWordWindow getWindow() {
        return window;
    }
}


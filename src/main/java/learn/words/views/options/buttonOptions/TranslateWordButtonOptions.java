package learn.words.views.options.buttonOptions;

import javax.swing.*;

public class TranslateWordButtonOptions extends AbstractGridButtonOptions {
    private final JTextField inputTextField;
    private final JTextField disabledTextField;

    public TranslateWordButtonOptions(JTextField inputTextField, JTextField disabledTextField,
                                      String buttonName, int gridX, int gridY) {
        super(buttonName, gridX, gridY);
        this.inputTextField = inputTextField;
        this.disabledTextField = disabledTextField;
    }

    public JTextField getInputTextField() {
        return inputTextField;
    }

    public JTextField getDisabledTextField() {
        return disabledTextField;
    }
}


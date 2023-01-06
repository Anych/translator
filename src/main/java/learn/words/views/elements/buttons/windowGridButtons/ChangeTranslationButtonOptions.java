package learn.words.views.elements.buttons.windowGridButtons;

import learn.words.views.options.buttonOptions.AbstractGridButtonOptions;
import learn.words.views.windows.TranslateWordWindow;

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

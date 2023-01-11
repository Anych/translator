package learn.words.view.element.textfield;

import learn.words.view.element.ElementFactory;

import javax.swing.*;

public abstract class AbstractTextField extends ElementFactory {
    protected JTextField textField;
    public JTextField getTextField() {
        return textField;
    }
}

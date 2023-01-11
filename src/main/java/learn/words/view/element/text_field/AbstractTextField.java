package learn.words.view.element.text_field;

import learn.words.view.element.ElementFactory;

import javax.swing.*;

public abstract class AbstractTextField extends ElementFactory {
    protected JTextField textField;
    public JTextField getTextField() {
        return textField;
    }
}

package learn.words.elements.textFields;

import learn.words.elements.AbstractElement;

import javax.swing.*;

public abstract class AbstractTextField extends AbstractElement {
    protected JTextField textField;

    public JTextField getTextField() {
        return textField;
    }
}

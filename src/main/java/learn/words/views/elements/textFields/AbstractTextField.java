package learn.words.views.elements.textFields;

import learn.words.views.elements.AbstractElement;

import javax.swing.*;

public abstract class AbstractTextField extends AbstractElement {
    protected JTextField textField;

    public JTextField getTextField() {
        return textField;
    }
}

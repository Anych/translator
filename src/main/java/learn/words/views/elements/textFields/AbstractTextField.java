package learn.words.views.elements.textFields;

import learn.words.views.elements.AbstractParticularElement;

import javax.swing.*;

public abstract class AbstractTextField extends AbstractParticularElement {
    protected JTextField textField;

    public JTextField getTextField() {
        return textField;
    }
}

package learn.words.view.element.text_field;

import learn.words.view.element.AbstractParticularElement;

import javax.swing.*;

public abstract class AbstractTextField extends AbstractParticularElement {
    protected JTextField textField;

    public JTextField getTextField() {
        return textField;
    }
}

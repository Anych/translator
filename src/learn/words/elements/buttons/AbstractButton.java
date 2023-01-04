package learn.words.elements.buttons;

import learn.words.elements.AbstractElement;

import javax.swing.*;

public abstract class AbstractButton extends AbstractElement {
    protected JButton button;

    public JButton getButton() {
        return button;
    }

    protected abstract void onClick();
}

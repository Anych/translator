package learn.words.view.element.button;

import learn.words.view.element.AbstractParticularElement;

import javax.swing.*;

public abstract class AbstractButton extends AbstractParticularElement {
    protected JButton button;

    public JButton getButton() {
        return button;
    }

    protected abstract void onClick();
}

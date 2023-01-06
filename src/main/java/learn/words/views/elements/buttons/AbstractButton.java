package learn.words.views.elements.buttons;

import learn.words.views.elements.AbstractParticularElement;

import javax.swing.*;

public abstract class AbstractButton extends AbstractParticularElement {
    protected JButton button;

    public JButton getButton() {
        return button;
    }

    protected abstract void onClick();
}

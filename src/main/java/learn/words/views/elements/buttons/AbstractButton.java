package learn.words.views.elements.buttons;

import learn.words.views.elements.AbstractElement;

import javax.swing.*;

public abstract class AbstractButton extends AbstractElement {
    protected JButton button;

    public JButton getButton() {
        return button;
    }

    protected abstract void onClick();
}

package learn.words.view.element.button;

import learn.words.view.element.ElementFactory;

import javax.swing.*;

public abstract class AbstractButton extends ElementFactory {
    protected JButton button;

    public JButton getButton() {
        return button;
    }

    protected abstract void onClick();
}

package learn.words.elements.buttons;

import javax.swing.*;

public abstract class AbstractButton {
    protected JButton button;
    public JButton getButton() {
        return button;
    }
    protected abstract void render();
    protected abstract void create();
    protected abstract void onClick();
}

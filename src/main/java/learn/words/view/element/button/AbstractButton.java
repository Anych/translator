package learn.words.view.element.button;

import learn.words.view.element.ActionOnClick;
import learn.words.view.element.ElementFactory;

import javax.swing.*;

public abstract class AbstractButton extends ElementFactory implements ActionOnClick {
    protected JButton button;
    public JButton getButton() {
        return button;
    }
}

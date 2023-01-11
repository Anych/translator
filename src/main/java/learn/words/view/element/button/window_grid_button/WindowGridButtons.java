package learn.words.view.element.button.window_grid_button;

import learn.words.view.element.AbstractParticularElement;
import learn.words.view.element.ComponentsFactory;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.element.button.gridbutton.GridButtonFactory;

import javax.swing.*;
import java.awt.*;

public abstract class WindowGridButtons implements ComponentsFactory {
    protected JFrame frame;
    protected Container pane;
    protected GridBagConstraints constraints;

    public WindowGridButtons(JFrame frame, Container pane, GridBagConstraints constraints) {
        this.frame = frame;
        this.pane = pane;
        this.constraints = constraints;
    }

    @Override
    public JButton createParticularElementOnPane(AbstractGridOptions options) {
        GridButtonFactory button = new GridButtonFactory();
        setElementOptions(options, button);

        button.render();
        button.create();
        button.onClick();

        pane.add(button.getButton(), constraints);

        return button.getButton();
    }

    @Override
    public void setElementOptions(AbstractGridOptions options, AbstractParticularElement element) {
        element.setConstraints(constraints);
        element.setOptions(options);
    }
}

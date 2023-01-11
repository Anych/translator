package learn.words.view.component;

import learn.words.view.element.ElementFactory;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.element.button.gridbutton.GridButtonFactory;

import javax.swing.*;
import java.awt.*;

public abstract class WindowButtonsBuilder implements CreateComponentsFactory {
    protected JFrame frame;
    protected Container pane;
    protected GridBagConstraints constraints;

    public WindowButtonsBuilder(JFrame frame, Container pane, GridBagConstraints constraints) {
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
    public void setElementOptions(AbstractGridOptions options, ElementFactory element) {
        element.setConstraints(constraints);
        element.setOptions(options);
    }
}

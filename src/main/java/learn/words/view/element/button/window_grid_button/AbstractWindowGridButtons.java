package learn.words.view.element.button.window_grid_button;

import learn.words.view.element.AbstractElements;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.element.button.grid_button.WindowParticularGridButton;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractWindowGridButtons extends AbstractElements {
    public AbstractWindowGridButtons(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    protected JButton createParticularElementOnPane(AbstractGridOptions options) {
        WindowParticularGridButton button = new WindowParticularGridButton();
        setElementOptions(options, button);

        button.render();
        button.create();
        button.onClick();

        pane.add(button.getButton(), constraints);

        return button.getButton();
    }
}

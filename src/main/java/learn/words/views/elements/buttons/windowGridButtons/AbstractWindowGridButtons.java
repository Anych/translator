package learn.words.views.elements.buttons.windowGridButtons;

import learn.words.views.elements.AbstractElements;
import learn.words.views.elements.AbstractParticularElement;
import learn.words.views.options.AbstractGridOptions;
import learn.words.views.elements.buttons.gridButton.WindowParticularGridButton;

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

    @Override
    protected void setElementOptions(AbstractGridOptions options, AbstractParticularElement button) {
        button.setConstraints(constraints);
        button.setOptions(options);
    }
}

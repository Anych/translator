package learn.words.views.elements.buttons.windowGridButtons;

import learn.words.views.elements.AbstractCreateElements;
import learn.words.views.elements.AbstractElement;
import learn.words.views.options.AbstractGridOptions;
import learn.words.views.elements.buttons.gridButton.WindowGridButton;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractCreateWindowGridButtons extends AbstractCreateElements {
    public AbstractCreateWindowGridButtons(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    protected JButton createParticularElementOnPane(AbstractGridOptions options) {
        WindowGridButton button = new WindowGridButton();
        setElementOptions(options, button);

        button.render();
        button.create();
        button.onClick();

        pane.add(button.getButton(), constraints);

        return button.getButton();
    }

    @Override
    protected void setElementOptions(AbstractGridOptions options, AbstractElement button) {
        button.setConstraints(constraints);
        button.setOptions(options);
    }
}

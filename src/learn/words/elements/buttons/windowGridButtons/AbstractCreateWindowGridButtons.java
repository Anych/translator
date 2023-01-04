package learn.words.elements.buttons.windowGridButtons;

import learn.words.elements.AbstractCreateElements;
import learn.words.elements.AbstractElement;
import learn.words.elements.buttons.gridButton.OpenNewWindowGridButton;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractCreateWindowGridButtons extends AbstractCreateElements {
    public AbstractCreateWindowGridButtons(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    protected void createParticularElementOnPane(Record options) {
        OpenNewWindowGridButton button = new OpenNewWindowGridButton();
        setElementOptions(options, button);

        button.render();
        button.create();
        button.onClick();

        pane.add(button.getButton(), constraints);
    }

    @Override
    protected void setElementOptions(Record options, AbstractElement button) {
        button.setConstraints(constraints);
        button.setOptions(options);
    }
}

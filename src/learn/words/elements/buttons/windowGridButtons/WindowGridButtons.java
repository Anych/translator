package learn.words.elements.buttons.windowGridButtons;

import learn.words.elements.buttons.gridButton.OpenNewWindowGridButton;
import learn.words.elements.buttons.gridButton.OpenNewWindowGridButtonOptions;

import javax.swing.*;
import java.awt.*;

public abstract class WindowGridButtons {
    protected JFrame frame;
    protected Container pane;
    protected GridBagConstraints constraints;

    public WindowGridButtons(JFrame frame, Container pane, GridBagConstraints constraints) {
        this.frame = frame;
        this.pane = pane;
        this.constraints = constraints;
    }

    public abstract void createButtons();

    protected void createParticularButtonOnPane(OpenNewWindowGridButtonOptions options) {
        OpenNewWindowGridButton button = new OpenNewWindowGridButton();
        setButtonOptions(options, button);

        button.render();
        button.create();
        button.onClick();

        pane.add(button.getButton(), constraints);
    }

    protected void setButtonOptions(OpenNewWindowGridButtonOptions options, OpenNewWindowGridButton button) {
        button.setConstraints(constraints);
        button.setOptions(options);
    }
}

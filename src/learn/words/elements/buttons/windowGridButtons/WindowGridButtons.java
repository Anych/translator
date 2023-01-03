package learn.words.elements.buttons.windowGridButtons;

import learn.words.elements.buttons.gridButton.GridButton;
import learn.words.elements.buttons.gridButton.GridButtonOptions;

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

    protected void createParticularButtonOnPane(GridButtonOptions options) {
        GridButton button = new GridButton();
        setButtonOptions(options, button);

        button.render();
        button.create();
        button.onClick();

        pane.add(button.getButton(), constraints);
    }

    protected void setButtonOptions(GridButtonOptions options, GridButton button) {
        button.setConstraints(constraints);
        button.setOptions(options);
        button.setRecordFields();
    }
}

package learn.words.elements.buttons.gridButton;

import learn.words.elements.buttons.AbstractButton;
import learn.words.elements.ElementOptions;
import learn.words.elements.buttons.actions.AbstractAction;
import learn.words.elements.buttons.actions.OpenOtherFrameAction;

import javax.swing.*;
import java.awt.*;

public class OpenNewWindowGridButton extends AbstractButton implements ElementOptions {
    OpenNewWindowGridButtonOptions options;
    private GridBagConstraints constraints;
    @Override
    public void setOptions(Record options) {
        this.options = (OpenNewWindowGridButtonOptions) options;
    }

    @Override
    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }

    @Override
    public void render() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = options.gridX();
        constraints.gridy = options.gridY();
    }

    @Override
    public void create() {
        button = new JButton(options.buttonName());
    }

    @Override
    public void onClick() {
        button.addActionListener(e -> {
            AbstractAction action = new OpenOtherFrameAction(options.frame(), options.newWindow());
            action.executeCommand();
        });
    }
}

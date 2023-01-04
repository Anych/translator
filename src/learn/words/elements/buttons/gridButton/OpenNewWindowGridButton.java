package learn.words.elements.buttons.gridButton;

import learn.words.elements.buttons.AbstractButton;
import learn.words.elements.actions.AbstractAction;
import learn.words.elements.actions.OpenOtherFrameAction;

import javax.swing.*;
import java.awt.*;

public class OpenNewWindowGridButton extends AbstractButton {
    OpenNewWindowGridButtonOptions options;

    @Override
    public void setOptions(Record options) {
        this.options = (OpenNewWindowGridButtonOptions) options;
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

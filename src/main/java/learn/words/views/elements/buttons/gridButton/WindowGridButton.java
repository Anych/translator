package learn.words.views.elements.buttons.gridButton;

import learn.words.views.elements.actions.CorrectAction;
import learn.words.views.elements.buttons.AbstractButton;
import learn.words.views.options.AbstractGridOptions;
import learn.words.views.options.buttonOptions.AbstractGridButtonOptions;

import javax.swing.*;
import java.awt.*;

public class WindowGridButton extends AbstractButton {
    AbstractGridButtonOptions options;

    @Override
    public void setOptions(AbstractGridOptions options) {
        this.options = (AbstractGridButtonOptions) options;
    }

    @Override
    public void render() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = options.getGridX();
        constraints.gridy = options.getGridY();
    }

    @Override
    public void create() {
        button = new JButton(options.getButtonName());
    }

    @Override
    public void onClick() {
        button.addActionListener(e -> {
            CorrectAction action = new CorrectAction(options);
            action.chooseCorrectAction();
            action.executeCommand();
        });
    }
}

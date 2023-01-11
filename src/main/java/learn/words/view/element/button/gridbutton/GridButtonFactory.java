package learn.words.view.element.button.gridbutton;

import learn.words.controller.action.CorrectAction;
import learn.words.view.element.button.AbstractButton;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.option.button_option.AbstractGridButtonOptions;

import javax.swing.*;
import java.awt.*;

public class GridButtonFactory extends AbstractButton {
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

package learn.words.view.element.button;

import learn.words.controller.action.CorrectAction;
import learn.words.view.element.ElementFactory;
import learn.words.view.option.GridButtonOptions;

import javax.swing.*;
import java.awt.*;

public class GridButtonFactory implements ElementFactory {
    GridBagConstraints constraints;
    GridButtonOptions options;
    JButton button;

    public GridButtonFactory(GridBagConstraints constraints, Container pane, GridButtonOptions options) {
        this.constraints = constraints;
        this.options = options;
        this.button = create();
        onClick();
        pane.add(button, constraints);
    }

    @Override
    public JButton create() {
        render();
        return createComponent();
    }

    @Override
    public void render() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = options.getGridX();
        constraints.gridy = options.getGridY();
    }

    @Override
    public void onClick() {
        button.addActionListener(e -> {
            CorrectAction action = new CorrectAction(options);
            action.chooseCorrectAction();
            action.executeCommand();
        });
    }

    @Override
    public JButton createComponent() {
        return new JButton(options.getButtonName());
    }

    @Override
    public JButton getComponent() {
        return button;
    }
}

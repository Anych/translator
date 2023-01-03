package learn.words.elements.buttons.gridButton;

import learn.words.elements.buttons.AbstractButton;
import learn.words.elements.ElementOptions;
import learn.words.elements.buttons.actions.AbstractAction;
import learn.words.elements.buttons.actions.OpenNewFrameAction;
import learn.words.windows.AbstractWindow;

import javax.swing.*;
import java.awt.*;

public class OpenNewWindowGridButton extends AbstractButton implements ElementOptions {
    OpenNewWindowGridButtonOptions options;
    AbstractWindow newWindow;
    JFrame frame;
    private GridBagConstraints constraints;
    private JButton button;

    @Override
    public void setOptions(Record options) {
        this.options = (OpenNewWindowGridButtonOptions) options;
    }

    @Override
    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }

    public JButton getButton() {
        return button;
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
            AbstractAction action = new OpenNewFrameAction(options.frame(), options.newWindow());
            action.executeCommand();
        });
    }
}

package learn.words.view.element.button.gridbutton;

import learn.words.controller.action.CorrectAction;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.option.buttonoption.ButtonWithImageOptions;

import javax.swing.*;
import java.awt.*;

public class ImageButtonFactory extends GridButtonFactory {
    private JButton button;
    protected ButtonWithImageOptions options;

    @Override
    public void create() {
        button = new JButton(new ImageIcon("src/main/resources/images/" + options.getImageName() + ".jpg"));
        button.setPreferredSize(new Dimension(27, 27));
    }

    @Override
    public void setOptions(AbstractGridOptions options) {
        this.options = (ButtonWithImageOptions) options;
    }

    @Override
    public void render() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = options.getGridX();
        constraints.gridy = options.getGridY();
    }

    public JButton getButton() {
        return button;
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

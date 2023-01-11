package learn.words.view.element.textfield.gridtextfield;

import learn.words.controller.action.FrameDragListener;
import learn.words.view.element.ActionOnClick;
import learn.words.view.element.textfield.AbstractTextField;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.option.textfieldoption.RepeatTextFieldOptions;

import javax.swing.*;
import java.awt.*;

public class RepeatGridTextField extends AbstractTextField implements ActionOnClick {
    RepeatTextFieldOptions options;

    @Override
    public void render() {
        textField = new JTextField(30);
        textField.setBackground(options.getColor());
        textField.setFont(new Font("Serif", Font.BOLD,20));
        textField.setBorder(null);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
    }

    @Override
    public void create() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = options.getGridX();
        constraints.gridy = options.getGridY();
        constraints.gridwidth = 2;
    }

    @Override
    public void setOptions(AbstractGridOptions options) {
        this.options = (RepeatTextFieldOptions) options;
    }

    @Override
    public void onClick() {
        Runnable runnable = () -> {
            FrameDragListener frameDragListener = new FrameDragListener(options.getFrame());
            textField.addMouseListener(frameDragListener);
            textField.addMouseMotionListener(frameDragListener);
        };
        SwingUtilities.invokeLater(runnable);
    }
}

package learn.words.view.element.text_field.grid_text_field;

import learn.words.view.element.text_field.AbstractTextField;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.option.text_fields_option.RepeatTextFieldOptions;

import javax.swing.*;
import java.awt.*;

public class RepeatGridTextField extends AbstractTextField {
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
        setMotionTextField();
    }

    @Override
    public void setOptions(AbstractGridOptions options) {
        this.options = (RepeatTextFieldOptions) options;
    }

    public void setMotionTextField() {
        Runnable runnable = () -> {
            FrameDragListener frameDragListener = new FrameDragListener(options.getFrame());
            textField.addMouseListener(frameDragListener);
            textField.addMouseMotionListener(frameDragListener);
        };
        SwingUtilities.invokeLater(runnable);
    }
}

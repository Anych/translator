package learn.words.view.element.text_field.grid_text_field;

import learn.words.view.option.AbstractGridOptions;
import learn.words.view.element.text_field.AbstractTextField;
import learn.words.view.option.text_fields_option.GridTextFieldOptions;

import javax.swing.*;
import java.awt.*;

public class GridTextField extends AbstractTextField {
    GridTextFieldOptions options;

    @Override
    public void setOptions(AbstractGridOptions options) {
        this.options = (GridTextFieldOptions) options;
    }

    @Override
    public void render() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = options.getGridX();
        constraints.gridy = options.getGridY();
        constraints.gridwidth = 2;
    }

    @Override
    public void create() {
        textField = new JTextField(30);
        textField.setEditable(options.isEditable());
    }
}

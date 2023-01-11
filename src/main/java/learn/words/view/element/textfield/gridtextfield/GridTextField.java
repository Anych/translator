package learn.words.view.element.textfield.gridtextfield;

import learn.words.view.option.AbstractGridOptions;
import learn.words.view.element.textfield.AbstractTextField;
import learn.words.view.option.textfieldoption.GridTextFieldOptions;

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

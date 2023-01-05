package learn.words.views.elements.textFields.gridTextField;

import learn.words.views.options.AbstractGridOptions;
import learn.words.views.elements.textFields.AbstractTextField;
import learn.words.views.options.textFieldsOptions.GridTextFieldOptions;

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

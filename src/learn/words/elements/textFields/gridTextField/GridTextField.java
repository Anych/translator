package learn.words.elements.textFields.gridTextField;

import learn.words.elements.textFields.AbstractTextField;

import javax.swing.*;
import java.awt.*;

public class GridTextField extends AbstractTextField {
    GridTextFieldOptions options;

    @Override
    public void setOptions(Record options) {
        this.options = (GridTextFieldOptions) options;
    }

    @Override
    public void render() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = options.gridX();
        constraints.gridy = options.gridY();
        constraints.gridwidth = 2;
    }

    @Override
    public void create() {
        textField = new JTextField(30);
        textField.setEditable(options.isEditable());
    }
}

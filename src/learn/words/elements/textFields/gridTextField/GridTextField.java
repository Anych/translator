package learn.words.elements.textFields.gridTextField;

import learn.words.elements.ElementOptions;
import learn.words.elements.textFields.AbstractTextField;

import javax.swing.*;
import java.awt.*;

public class GridTextField implements AbstractTextField, ElementOptions {
    GridTextOptions options;
    private GridBagConstraints constraints;
    private JTextField textField;

    @Override
    public void setOptions(Record options) {
        this.options = (GridTextOptions) options;
    }

    @Override
    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }

    public JTextField getTextField() {
        return textField;
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

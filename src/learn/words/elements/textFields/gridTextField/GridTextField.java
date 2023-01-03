package learn.words.elements.textFields.gridTextField;

import learn.words.elements.ElementOptions;
import learn.words.elements.textFields.AbstractTextField;

import javax.swing.*;
import java.awt.*;

public class GridTextField implements AbstractTextField, ElementOptions {
    GridTextOptions options;
    private GridBagConstraints constraints;
    private int gridX;
    private int gridY;
    private JTextField textField;

    @Override
    public void setOptions(Record options) {
        this.options = (GridTextOptions) options;
    }

    @Override
    public void setRecordFields() {
        setGridX(options.gridX());
        setGridY(options.gridY());
    }

    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }

    public void setGridX(int gridX) {
        this.gridX = gridX;
    }

    public void setGridY(int gridY) {
        this.gridY = gridY;
    }

    public JTextField getTextField() {
        return textField;
    }

    @Override
    public void render() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.gridwidth = 2;
    }

    @Override
    public void create() {
        textField = new JTextField(30);
    }
}

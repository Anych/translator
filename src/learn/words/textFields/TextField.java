package learn.words.textFields;

import javax.swing.*;
import java.awt.*;

public class TextField implements AbstractTextField {
    private GridBagConstraints constraints;
    private int gridX;
    private int gridY;
    private JTextField textField;

    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }

    private void setGridX(int gridX) {
        this.gridX = gridX;
    }

    private void setGridY(int gridY) {
        this.gridY = gridY;
    }

    private JTextField getTextField() {
        return textField;
    }

    @Override
    public void render() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
    }

    public void create() {
        textField = new JTextField(30);
    }
}

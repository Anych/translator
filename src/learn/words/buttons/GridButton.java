package learn.words.buttons;

import learn.words.windows.AbstractWindow;

import javax.swing.*;
import java.awt.*;

public class GridButton extends Button {

    private GridBagConstraints constraints;
    private String buttonName;
    private int gridX;
    private int gridY;
    private JButton button;
    GridButtonOptions options;
    AbstractWindow dialog;

    public void setButtonOptions(GridButtonOptions options) {
        this.options = options;
    }

    public void setOptionsFields() {
        setDialog(options.dialog());
        setButtonName(options.buttonName());
        setGridX(options.gridX());
        setGridY(options.gridY());
    }

    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }

    private void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    private void setGridX(int gridX) {
        this.gridX = gridX;
    }

    private void setGridY(int gridY) {
        this.gridY = gridY;
    }
    private void setDialog(AbstractWindow dialog) {
        this.dialog = dialog;
    }

    public JButton getButton() {
        return button;
    }

    @Override
    public void render() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
    }

    public void create() {
        button = new JButton(buttonName);
    }

    @Override
    public void onClick() {
        button.addActionListener(e -> dialog.renderWindow());
    }
}

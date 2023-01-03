package learn.words.elements.buttons.gridButton;

import learn.words.elements.buttons.AbstractButton;
import learn.words.elements.ElementOptions;
import learn.words.windows.AbstractWindow;

import javax.swing.*;
import java.awt.*;

public class GridButton extends AbstractButton implements ElementOptions {
    GridButtonOptions options;
    AbstractWindow newWindow;
    JFrame frame;
    private GridBagConstraints constraints;
    private String buttonName;
    private int gridX;
    private int gridY;
    private JButton button;

    @Override
    public void setOptions(Record options) {
        this.options = (GridButtonOptions) options;
    }

    @Override
    public void setRecordFields() {
        setNewWindow(options.newWindow());
        setFrame(options.frame());
        setButtonName(options.buttonName());
        setGridX(options.gridX());
        setGridY(options.gridY());
    }

    @Override
    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }

    private void setNewWindow(AbstractWindow newWindow) {
        this.newWindow = newWindow;
    }

    private void setFrame(JFrame frame) {
        this.frame = frame;
    }

    private void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    @Override
    public void setGridX(int gridX) {
        this.gridX = gridX;
    }

    @Override
    public void setGridY(int gridY) {
        this.gridY = gridY;
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

    @Override
    public void create() {
        button = new JButton(buttonName);
    }

    @Override
    public void onClick() {
        button.addActionListener(e -> {
            frame.dispose();
            newWindow.renderWindow();
            newWindow.createElements();
        });
    }
}

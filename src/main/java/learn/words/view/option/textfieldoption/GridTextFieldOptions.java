package learn.words.view.option.textfieldoption;

import learn.words.view.option.AbstractGridOptions;

import javax.swing.*;
import java.awt.*;

public class GridTextFieldOptions extends AbstractGridOptions {
    private boolean isEditable;
    private Color color;
    private JFrame frame;

    public GridTextFieldOptions(JFrame frame, Color color, int gridX, int gridY) {
        super(gridX, gridY);
        this.frame = frame;
        this.color = color;
    }

    public GridTextFieldOptions(boolean isEditable, int gridX, int gridY) {
        super(gridX, gridY);
        this.isEditable = isEditable;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Color getColor() {
        return color;
    }

    public boolean isEditable() {
        return isEditable;
    }
}
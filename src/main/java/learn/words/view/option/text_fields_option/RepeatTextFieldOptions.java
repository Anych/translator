package learn.words.view.option.text_fields_option;

import learn.words.view.option.AbstractGridOptions;

import javax.swing.*;
import java.awt.*;

public class RepeatTextFieldOptions extends AbstractGridOptions {
    private final JFrame frame;
    private final Color color;

    public RepeatTextFieldOptions(int gridX, int gridY, JFrame frame, Color color) {
        super(gridX, gridY);
        this.frame = frame;
        this.color = color;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Color getColor() {
        return color;
    }
}

package learn.words.windows;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractWindow {
    protected JFrame frame;
    protected Container pane;
    protected GridBagConstraints constraints;

    public abstract void renderWindow();
    public abstract void createElements();

    protected void setFrameOptions(int width, int height) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    protected void setPaneOptions() {
        pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());
    }

    protected void setConstraints() {
        this.constraints = new GridBagConstraints();
    }
}

package learn.words.windows;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractWindow {
    protected JFrame frame;
    protected Container pane;

    public abstract void renderWindow();
    public abstract void createElements();

    protected void setFrameOptions(int width, int height) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    protected void setPaneOptions() {
        pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());
    }
}

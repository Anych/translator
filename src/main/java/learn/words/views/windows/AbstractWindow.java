package learn.words.views.windows;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractWindow {
    protected JFrame frame;
    protected Container pane;
    protected GridBagConstraints constraints;
    private final int WIDTH;
    private final int HEIGHT;

    protected AbstractWindow(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    public void renderWindow() {
        setFrameOptions();
        setPaneOptions();
        setConstraints();
        setWindowSize();
        setWindowLocation();
    }

    protected void setFrameOptions() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    protected void setPaneOptions() {
        pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());
    }

    protected void setConstraints() {
        this.constraints = new GridBagConstraints();
    }

    public abstract void createElements();
    protected abstract void setWindowSize();
    protected void setWindowLocation() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - WIDTH) / 2;
        int locationY = (screenSize.height  - HEIGHT) / 2;
        frame.setBounds(locationX, locationY, WIDTH, HEIGHT);
    }
}

package learn.words.view.window;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractWindow {
    protected JFrame frame;
    protected Container pane;
    protected GridBagConstraints constraints;
    private final int WIDTH;
    private final int HEIGHT;

    public AbstractWindow(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    public void renderWindow(boolean isResizable) {
        setFrameOptions(isResizable);
        setPaneOptions();
        setConstraints();
        setWindowSize();
        setWindowLocation();
    }

    protected void setFrameOptions(boolean isResizable) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(isResizable);
        isUndecorated();
        frame.pack();
        frame.setVisible(true);
    }

    protected void setPaneOptions() {
        pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());
    }

    protected void setWindowSize() {
        frame.setSize(WIDTH, HEIGHT);
    }

    protected void setConstraints() {
        this.constraints = new GridBagConstraints();
    }

    public abstract void createElements();
    protected abstract void isUndecorated();
    protected void setWindowLocation() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - WIDTH) / 2;
        int locationY = (screenSize.height  - HEIGHT) / 2;
        frame.setBounds(locationX, locationY, WIDTH, HEIGHT);
    }
}

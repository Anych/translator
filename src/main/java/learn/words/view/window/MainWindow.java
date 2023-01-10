package learn.words.view.window;

import learn.words.view.element.button.window_grid_button.MainWindowButtons;
import learn.words.view.element.button.window_grid_button.AbstractWindowGridButtons;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends AbstractWindow {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 90;

    public MainWindow() {
        super(WIDTH, HEIGHT);
        this.frame = new JFrame("Слова бегом");
    }

    @Override
    public void createElements() {
        AbstractWindowGridButtons buttons = new MainWindowButtons(frame, pane, constraints);
        buttons.createElements();
    }

    @Override
    protected void setWindowSize() {
        frame.setSize(WIDTH, HEIGHT);
    }

    @Override
    protected void isUndecorated() {
        frame.setUndecorated(false);
    }

    @Override
    protected void setWindowLocation() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - WIDTH) / 2;
        int locationY = (screenSize.height  - HEIGHT) / 2;
        frame.setBounds(locationX, locationY, WIDTH, HEIGHT);
    }
}

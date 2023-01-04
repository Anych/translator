package learn.words.views.windows;

import learn.words.views.elements.buttons.windowGridButtons.CreateMainWindowButtons;
import learn.words.views.elements.buttons.windowGridButtons.AbstractCreateWindowGridButtons;

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
        AbstractCreateWindowGridButtons buttons = new CreateMainWindowButtons(frame, pane, constraints);
        buttons.createElements();
    }

    @Override
    protected void setWindowSize() {
        frame.setSize(WIDTH, HEIGHT);
    }

    @Override
    protected void setWindowLocation() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - WIDTH) / 2;
        int locationY = (screenSize.height  - HEIGHT) / 2;
        frame.setBounds(locationX, locationY, WIDTH, HEIGHT);
    }
}

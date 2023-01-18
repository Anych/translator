package learn.words.view.window;

import learn.words.view.element.button.GridButtonFactory;
import learn.words.view.option.GridButtonOptions;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends AbstractWindowBuilder {
    private static final int WIDTH = 270;
    private static final int HEIGHT = 65;

    public MainWindow() {
        super(WIDTH, HEIGHT);
        this.frame = new JFrame("Слова бегом");
    }

    @Override
    public void createComponents() {
        new GridButtonFactory(constraints, pane, new GridButtonOptions(
                new TranslateWordWindow(), frame,
                "Добавить слово", 0, 0));
        new GridButtonFactory(constraints, pane, new GridButtonOptions(
                new LearnWordWindow(), frame,
                "Выучить слова", 1, 0));
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
    protected void isResizable() {
        frame.setResizable(false);
    }

    @Override
    protected void setWindowLocation() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - WIDTH) / 2;
        int locationY = (screenSize.height  - HEIGHT) / 2;
        frame.setBounds(locationX, locationY, WIDTH, HEIGHT);
    }
}

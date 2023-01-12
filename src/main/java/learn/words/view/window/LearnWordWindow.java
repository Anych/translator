package learn.words.view.window;

import learn.words.view.element.button.ImageButtonFactory;
import learn.words.view.element.textfield.RepeatGridTextFieldFactory;
import learn.words.view.option.GridButtonOptions;
import learn.words.view.option.GridTextFieldOptions;

import javax.swing.*;
import java.awt.*;

public class LearnWordWindow extends AbstractWindow {
    private static final int WIDTH = 477;
    private static final int HEIGHT = 54;
    public LearnWordWindow() {
        super(WIDTH, HEIGHT);
        this.frame = new JFrame();
    }

    @Override
    public void createElements() {
        JTextField learningWord = new RepeatGridTextFieldFactory(constraints, pane,
                new GridTextFieldOptions(frame, Color.YELLOW, 0, 0)).getTextField();

        JTextField translateOfLearningWord = new RepeatGridTextFieldFactory(constraints, pane,
                new GridTextFieldOptions(frame, Color.WHITE, 0, 0)).getTextField();

        new ImageButtonFactory(constraints, pane, new GridButtonOptions(
                new MainWindow(), frame, "exit", 3, 0));

        new ImageButtonFactory(constraints, pane, new GridButtonOptions(
                new MainWindow(), frame, "save", 3, 1));
    }

    @Override
    protected void setWindowSize() {
        frame.setSize(WIDTH, HEIGHT);
    }

    @Override
    protected void isUndecorated() {
        frame.setUndecorated(true);
    }
}

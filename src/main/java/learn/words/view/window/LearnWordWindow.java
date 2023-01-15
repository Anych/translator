package learn.words.view.window;

import learn.words.controller.action.learnwindowactions.LearnWordsOnTextFields;
import learn.words.view.element.button.ImageButtonFactory;
import learn.words.view.element.textfield.LearnGridTextFieldFactory;
import learn.words.view.option.GridButtonOptions;
import learn.words.view.option.GridTextFieldOptions;

import javax.swing.*;
import java.awt.*;

public class LearnWordWindow extends AbstractWindowBuilder {
    private static final int WIDTH = 477;
    private static final int HEIGHT = 54;
    private JTextField learningWord;
    private JTextField translateOfLearningWord;
    private JButton saveButton;
    public LearnWordWindow() {
        super(WIDTH, HEIGHT);
        this.frame = new JFrame();
    }

    public void createWindow() {
        setFrameOptions();
        setPaneOptions();
        setConstraints();
        setWindowSize();
        setWindowLocation();
        createComponents();
        setWordsInFields();
    }

    @Override
    public void createComponents() {
        learningWord = new LearnGridTextFieldFactory(constraints, pane,
                new GridTextFieldOptions(frame, Color.YELLOW, 0, 0)).getComponent();

        translateOfLearningWord = new LearnGridTextFieldFactory(constraints, pane,
                new GridTextFieldOptions(frame, Color.WHITE, 0, 1)).getComponent();

        new ImageButtonFactory(constraints, pane, new GridButtonOptions(
                new MainWindow(), frame, "exit", 2, 0));

        saveButton = new ImageButtonFactory(constraints, pane, new GridButtonOptions(
                new MainWindow(), frame, "save", 2, 1)).getComponent();
    }

    @Override
    protected void setWindowSize() {
        frame.setSize(WIDTH, HEIGHT);
    }

    @Override
    protected void isResizable() {
        frame.setResizable(false);
    }

    @Override
    protected void isUndecorated() {
        frame.setUndecorated(true);
    }

    private void setWordsInFields() {
        Runnable task = () -> new LearnWordsOnTextFields(learningWord, translateOfLearningWord, saveButton);
        Thread thread = new Thread(task);
        thread.start();
    }
}

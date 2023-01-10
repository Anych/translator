package learn.words.view.window;

import learn.words.view.element.text_field.window_text_field.LearnWordsTextFields;
import learn.words.view.element.text_field.window_text_field.TranslateWordWindowTextFields;

import javax.swing.*;

public class RepeatWordWindow extends AbstractWindow {
    private static final int WIDTH = 450;
    private static final int HEIGHT = 54;
    public JTextField learningWord;
    public JTextField translateOfLearningWord;

    public RepeatWordWindow() {
        super(WIDTH, HEIGHT);
        this.frame = new JFrame();
    }

    @Override
    public void createElements() {
        LearnWordsTextFields textFields =
                new LearnWordsTextFields(frame, pane, constraints);
        textFields.createElements();
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

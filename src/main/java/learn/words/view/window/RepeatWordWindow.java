package learn.words.view.window;

import learn.words.view.component.windowbuttons.LearnWordsButtons;
import learn.words.view.component.windowtextfields.LearnWordsTextFields;

import javax.swing.*;

public class RepeatWordWindow extends AbstractWindow {
    private static final int WIDTH = 477;
    private static final int HEIGHT = 54;
    public RepeatWordWindow() {
        super(WIDTH, HEIGHT);
        this.frame = new JFrame();
    }

    @Override
    public void createElements() {
        LearnWordsTextFields textFields =
                new LearnWordsTextFields(frame, pane, constraints);
        textFields.createElements();

        LearnWordsButtons buttons = new LearnWordsButtons(frame, pane, constraints, textFields.getLearningWord(),
                textFields.getTranslateOfLearningWord());
        buttons.createElements();
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

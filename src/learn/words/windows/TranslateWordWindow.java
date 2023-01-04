package learn.words.windows;

import learn.words.elements.buttons.windowGridButtons.CreateTranslateWordWindowButtons;
import learn.words.elements.buttons.windowGridButtons.AbstractCreateWindowGridButtons;
import learn.words.elements.textFields.windowTextFields.CreateTranslateWordWindowTextFields;

import javax.swing.*;

public class TranslateWordWindow extends AbstractWindow {

    private static final int WIDTH = 690;
    private static final int HEIGHT = 140;

    public TranslateWordWindow() {
        super(WIDTH, HEIGHT);
        this.frame = new JFrame("Переводчик");
    }

    @Override
    public void createElements() {
        AbstractCreateWindowGridButtons buttons = new CreateTranslateWordWindowButtons(frame, pane, constraints);
        buttons.createElements();

        CreateTranslateWordWindowTextFields textFields = new CreateTranslateWordWindowTextFields(frame, pane, constraints);
        textFields.createElements();
    }

    @Override
    protected void setWindowSize() {
        frame.setSize(WIDTH, HEIGHT);
    }
}

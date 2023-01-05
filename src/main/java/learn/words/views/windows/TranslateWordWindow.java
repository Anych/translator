package learn.words.views.windows;

import learn.words.views.elements.buttons.windowGridButtons.CreateTranslateWordWindowButtons;
import learn.words.views.elements.buttons.windowGridButtons.AbstractCreateWindowGridButtons;
import learn.words.views.elements.textFields.windowTextFields.CreateTranslateWordWindowTextFields;

import javax.swing.*;

public class TranslateWordWindow extends AbstractWindow {

    private static final int WIDTH = 690;
    private static final int HEIGHT = 115;

    public TranslateWordWindow() {
        super(WIDTH, HEIGHT);
        this.frame = new JFrame("Переводчик");
    }

    @Override
    public void createElements() {
        CreateTranslateWordWindowTextFields textFields =
                new CreateTranslateWordWindowTextFields(frame, pane, constraints);
        textFields.createElements();

        AbstractCreateWindowGridButtons buttons =
                new CreateTranslateWordWindowButtons(frame, pane, constraints,
                        textFields.inputTextField, textFields.disabledTextField);
        buttons.createElements();
    }

    @Override
    protected void setWindowSize() {
        frame.setSize(WIDTH, HEIGHT);
    }
}

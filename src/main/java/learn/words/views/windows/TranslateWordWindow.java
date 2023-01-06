package learn.words.views.windows;

import learn.words.views.elements.buttons.windowGridButtons.TranslateWordWindowButtons;
import learn.words.views.elements.buttons.windowGridButtons.AbstractWindowGridButtons;
import learn.words.views.elements.textFields.windowTextFields.TranslateWordWindowTextFields;

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
        TranslateWordWindowTextFields textFields =
                new TranslateWordWindowTextFields(frame, pane, constraints);
        textFields.createElements();

        AbstractWindowGridButtons buttons =
                new TranslateWordWindowButtons(frame, pane, constraints,
                        textFields.inputTextField, textFields.disabledTextField);
        buttons.createElements();
    }

    @Override
    protected void setWindowSize() {
        frame.setSize(WIDTH, HEIGHT);
    }
}

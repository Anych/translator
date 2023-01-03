package learn.words.windows;

import learn.words.elements.buttons.windowGridButtons.TranslateWordWindowButtons;
import learn.words.elements.buttons.windowGridButtons.WindowGridButtons;
import learn.words.elements.textFields.windowTextFields.TranslateWordWindowTextFields;

import javax.swing.*;

public class TranslateWordWindow extends AbstractWindow {

    public TranslateWordWindow() {
        this.frame = new JFrame("Переводчик");
    }

    @Override
    public void createElements() {
        WindowGridButtons buttons = new TranslateWordWindowButtons(frame, pane, constraints);
        buttons.createButtons();

        TranslateWordWindowTextFields textFields = new TranslateWordWindowTextFields(frame, pane, constraints);
        textFields.createTextFields();
    }

    @Override
    protected void setWindowSize() {
        frame.setSize(690, 140);
    }
}

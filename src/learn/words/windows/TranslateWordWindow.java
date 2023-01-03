package learn.words.windows;

import learn.words.buttons.windowGridButtons.MainWindowButtons;
import learn.words.buttons.windowGridButtons.TranslateWordWindowButtons;
import learn.words.buttons.windowGridButtons.WindowGridButtons;
import learn.words.textFields.TextField;

import javax.swing.*;

public class TranslateWordWindow extends AbstractWindow {

    public TranslateWordWindow() {
        this.frame = new JFrame("Переводчик");
    }

    @Override
    protected void setWindowSize() {
        frame.setSize(750, 90);
    }
    @Override
    public void createElements() {
        WindowGridButtons buttons = new TranslateWordWindowButtons(frame, pane, constraints);
        buttons.createButtons();


    }

    private TextField createTextField() {
        return new TextField();
    }
}

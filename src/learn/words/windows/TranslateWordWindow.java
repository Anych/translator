package learn.words.windows;

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

    }

    private TextField createTextField() {
        return new TextField();
    }
}

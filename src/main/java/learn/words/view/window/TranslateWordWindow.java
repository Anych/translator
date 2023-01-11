package learn.words.view.window;

import learn.words.view.component.windowbuttons.TranslatorWindowButtons;
import learn.words.view.component.windowtextfields.TranslateWordWindowTextFields;

import javax.swing.*;
import java.util.List;

public class TranslateWordWindow extends AbstractWindow {
    private static final int WIDTH = 690;
    private static final int HEIGHT = 140;
    private List<String> translatedWords;
    private String wordToTranslate;

    public TranslateWordWindow() {
        super(WIDTH, HEIGHT);
        this.frame = new JFrame("Переводчик");
    }

    @Override
    public void createElements() {
        TranslateWordWindowTextFields textFields =
                new TranslateWordWindowTextFields(frame, pane, constraints);
        textFields.createElements();

        TranslatorWindowButtons buttons =
                new TranslatorWindowButtons(this, frame, pane, constraints,
                        textFields.getInputTextField(), textFields.getDisabledTextField());
        buttons.createElements();
    }

    @Override
    protected void isUndecorated() {
        frame.setUndecorated(false);
    }

    public void setTranslatedWords(List<String> translatedWords) {
        this.translatedWords = translatedWords;
    }

    public List<String> getTranslatedWords() {
        return translatedWords;
    }

    public void setWordToTranslate(String wordToTranslate) {
        this.wordToTranslate = wordToTranslate;
    }

    public String getWordToTranslate() {
        return wordToTranslate;
    }
}

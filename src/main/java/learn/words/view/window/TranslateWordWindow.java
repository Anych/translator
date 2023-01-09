package learn.words.view.window;

import learn.words.view.element.button.window_grid_button.TranslateWordWindowButtons;
import learn.words.view.element.button.window_grid_button.AbstractWindowGridButtons;
import learn.words.view.element.text_field.window_text_field.TranslateWordWindowTextFields;

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

        AbstractWindowGridButtons buttons =
                new TranslateWordWindowButtons(this, frame, pane, constraints,
                        textFields.inputTextField, textFields.disabledTextField);
        buttons.createElements();
    }

    @Override
    protected void setWindowSize() {
        frame.setSize(WIDTH, HEIGHT);
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

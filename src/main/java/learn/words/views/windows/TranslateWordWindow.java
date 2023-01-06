package learn.words.views.windows;

import learn.words.views.elements.buttons.windowGridButtons.TranslateWordWindowButtons;
import learn.words.views.elements.buttons.windowGridButtons.AbstractWindowGridButtons;
import learn.words.views.elements.textFields.windowTextFields.TranslateWordWindowTextFields;

import javax.swing.*;
import java.util.List;

public class TranslateWordWindow extends AbstractWindow {

    private static final int WIDTH = 690;
    private static final int HEIGHT = 140;
    private List<String> translatedWords;
    private String textToTranslate;

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

    public void setTextToTranslate(String textToTranslate) {
        this.textToTranslate = textToTranslate;
    }

    public String getTextToTranslate() {
        return textToTranslate;
    }
}

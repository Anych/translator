package learn.words.controllers.actions;

import learn.words.views.elements.buttons.windowGridButtons.ChangeTranslationButtonOptions;

import javax.swing.*;
import java.util.List;

// TODO: create new abstract class with translate word actions and new class for options
public class ChangeTranslationAction implements AbstractAction {
    private final ChangeTranslationButtonOptions options;

    public ChangeTranslationAction(ChangeTranslationButtonOptions options) {
        this.options = options;
    }

    @Override
    public void executeCommand() {
        String translatedText = getCurrentTranslation();
        int textIndex = getTranslatedTextIndex(translatedText);

        if (textIndex == -1) {
            options.getDisabledTextField().setText("Ошибка");
        } else {
            setDisabledTextFieldValue(textIndex);
        }
    }

    private void setDisabledTextFieldValue(int textIndex) {
        List<String> translatedWords = getTranslatedWords();
        int size = translatedWords.size() - 1;

        JTextField textField = options.getDisabledTextField();
        String button = options.getButtonName();

        if (button.equals("Предыдущий перевод") && textIndex > 0) {
            textField.setText(translatedWords.get(textIndex - 1));

        } else if (button.equals("Предыдущий перевод") && textIndex == 0) {
            textField.setText(translatedWords.get(size));

        } else if (button.equals("Следующий перевод") && textIndex < size) {
            textField.setText(translatedWords.get(textIndex + 1));

        } else {
            textField.setText(translatedWords.get(0));
        }
    }

    private String getCurrentTranslation() {
        return options.getDisabledTextField().getText();
    }

    private int getTranslatedTextIndex(String translatedText) {
        List<String> translatedTexts = options.getWindow().getTranslatedWords();
        return translatedTexts.indexOf(translatedText);
    }

    private List<String> getTranslatedWords() {
        return options.getWindow().getTranslatedWords();
    }
}

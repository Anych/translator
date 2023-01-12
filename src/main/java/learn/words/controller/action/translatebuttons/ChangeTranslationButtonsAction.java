package learn.words.controller.action.translatebuttons;

import learn.words.controller.action.ActionFactory;
import learn.words.view.option.GridButtonOptions;

import javax.swing.*;
import java.util.List;

public class ChangeTranslationButtonsAction implements ActionFactory {
    private final GridButtonOptions options;

    public ChangeTranslationButtonsAction(GridButtonOptions options) {
        this.options = options;
    }

    @Override
    public void executeCommand() {
        String translatedWord = getCurrentTranslation();
        int wordIndex = getTranslatedFieldIndex(translatedWord);

        if (wordIndex == -1) {
            options.getDisabledTextField().setText("Сначала переведите слово");
        } else {
            setDisabledTextFieldValue(wordIndex);
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

    private int getTranslatedFieldIndex(String translatedText) {
        List<String> translatedTexts = options.getTranslateWordWindow().getTranslatedWords();
        if (translatedTexts != null) {
            return translatedTexts.indexOf(translatedText);
        }
        return -1;
    }

    private List<String> getTranslatedWords() {
        return options.getTranslateWordWindow().getTranslatedWords();
    }
}

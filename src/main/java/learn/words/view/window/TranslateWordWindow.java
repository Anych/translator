package learn.words.view.window;

import learn.words.view.element.button.GridButtonFactory;
import learn.words.view.element.textfield.GridTextFieldFactory;
import learn.words.view.option.GridButtonOptions;
import learn.words.view.option.GridTextFieldOptions;

import javax.swing.*;
import java.util.List;

public class TranslateWordWindow extends AbstractWindowBuilder {
    private static final int WIDTH = 690;
    private static final int HEIGHT = 140;
    private List<String> translatedWords;
    private String wordToTranslate;

    public TranslateWordWindow() {
        super(WIDTH, HEIGHT);
        this.frame = new JFrame("Переводчик");
    }

    @Override
    public void createComponents() {
        JTextField inputTextField = new GridTextFieldFactory(constraints, pane,
                new GridTextFieldOptions(true, 0, 0)).getTextField();

        JTextField disabledTextField = new GridTextFieldFactory(constraints, pane,
                new GridTextFieldOptions(false, 3, 0)).getTextField();

        new GridButtonFactory(constraints, pane, new GridButtonOptions(this,
                inputTextField, disabledTextField, "Перевести слово", 1, 1));

        new GridButtonFactory(constraints, pane, new GridButtonOptions(this,
                inputTextField, disabledTextField, "Сохранить", 3, 1));

        new GridButtonFactory(constraints, pane, new GridButtonOptions(this,
                disabledTextField, "Предыдущий перевод", 1, 2));

        new GridButtonFactory(constraints, pane, new GridButtonOptions(this,
                disabledTextField, "Следующий перевод", 3, 2));

        new GridButtonFactory(constraints, pane, new GridButtonOptions(this,
                inputTextField, disabledTextField, "Очистить", 1, 3));

        new GridButtonFactory(constraints, pane, new GridButtonOptions(
                new MainWindow(), frame, "В главное меню", 3, 3));
    }

    @Override
    protected void isUndecorated() {
        frame.setUndecorated(false);
    }

    @Override
    protected void isResizable() {
        frame.setResizable(false);
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

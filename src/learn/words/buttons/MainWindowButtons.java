package learn.words.buttons;

import learn.words.windows.TranslateWordWindow;

import javax.swing.*;
import java.awt.*;

public class MainWindowButtons {
    private final GridBagConstraints constraints;
    final private JFrame frame;
    final private Container pane;

    public MainWindowButtons(JFrame frame, Container pane) {
        this.frame = frame;
        this.pane = pane;
        this.constraints = new GridBagConstraints();
    }

    public void createButtons() {
        createParticularButtonOnPane(new GridButtonOptions(
                new TranslateWordWindow(frame), "Добавить слово", 0, 0));
        createParticularButtonOnPane(new GridButtonOptions(
                new TranslateWordWindow(frame), "Выучить новые слова", 1, 0));
        createParticularButtonOnPane(new GridButtonOptions(
                new TranslateWordWindow(frame), "Повторить выученные слова", 0, 1));
        createParticularButtonOnPane(new GridButtonOptions(
                new TranslateWordWindow(frame), "Посмотреть список слов", 1, 1));
    }

    private void createParticularButtonOnPane(GridButtonOptions options) {
        GridButton button = new GridButton();
        setButtonOptions(options, button);

        button.render();
        button.create();
        button.onClick();

        pane.add(button.getButton(), constraints);
    }

    private void setButtonOptions(GridButtonOptions options, GridButton button) {
        button.setConstraints(constraints);
        button.setButtonOptions(options);
        button.setOptionsFields();
    }
}

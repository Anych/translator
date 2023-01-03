package learn.words.buttons.windowGridButtons;

import learn.words.buttons.gridButton.GridButtonOptions;
import learn.words.windows.TranslateWordWindow;

import javax.swing.*;
import java.awt.*;

public class MainWindowButtons extends WindowGridButtons {

    public MainWindowButtons(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
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
}

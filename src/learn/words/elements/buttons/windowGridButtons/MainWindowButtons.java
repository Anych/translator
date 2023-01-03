package learn.words.elements.buttons.windowGridButtons;

import learn.words.elements.buttons.gridButton.OpenNewWindowGridButtonOptions;
import learn.words.windows.TranslateWordWindow;

import javax.swing.*;
import java.awt.*;

public class MainWindowButtons extends WindowGridButtons {

    public MainWindowButtons(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    public void createButtons() {
        createParticularButtonOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Добавить слово", 0, 0));
        createParticularButtonOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Выучить новые слова", 1, 0));
        createParticularButtonOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Повторить выученные слова", 0, 1));
        createParticularButtonOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Посмотреть список слов", 1, 1));
    }
}

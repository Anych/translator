package learn.words.buttons.windowGridButtons;

import learn.words.buttons.gridButton.GridButton;
import learn.words.buttons.gridButton.GridButtonOptions;
import learn.words.windows.TranslateWordWindow;

import javax.swing.*;
import java.awt.*;

public class TranslateWordWindowButtons extends WindowGridButtons {

    public TranslateWordWindowButtons(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    public void createButtons() {
        createParticularButtonOnPane(new GridButtonOptions(
                new TranslateWordWindow(), frame, "Перевести слово", 0, 1));
        createParticularButtonOnPane(new GridButtonOptions(
                new TranslateWordWindow(), frame, "Следующий перевод", 1, 1));
        createParticularButtonOnPane(new GridButtonOptions(
                new TranslateWordWindow(), frame, "Предыдущий перевод", 2, 1));
        createParticularButtonOnPane(new GridButtonOptions(
                new TranslateWordWindow(), frame, "Сохранить перевод", 3, 1));
        createParticularButtonOnPane(new GridButtonOptions(
                new TranslateWordWindow(), frame, "В главное меню", 4, 1));
    }
}

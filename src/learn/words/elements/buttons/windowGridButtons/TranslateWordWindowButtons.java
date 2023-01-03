package learn.words.elements.buttons.windowGridButtons;

import learn.words.elements.buttons.gridButton.OpenNewWindowGridButtonOptions;
import learn.words.windows.MainWindow;
import learn.words.windows.TranslateWordWindow;

import javax.swing.*;
import java.awt.*;

public class TranslateWordWindowButtons extends WindowGridButtons {

    public TranslateWordWindowButtons(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    public void createButtons() {
        createParticularButtonOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Перевести слово", 1, 1));
        createParticularButtonOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Сохранить перевод", 3, 1));
        createParticularButtonOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Следующий перевод", 1, 2));
        createParticularButtonOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Предыдущий перевод", 3, 2));
        createParticularButtonOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Очистить поле", 1, 3));
        createParticularButtonOnPane(new OpenNewWindowGridButtonOptions(
                new MainWindow(), frame, "В главное меню", 3, 3));

    }
}

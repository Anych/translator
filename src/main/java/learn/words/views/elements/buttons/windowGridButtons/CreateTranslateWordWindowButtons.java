package learn.words.views.elements.buttons.windowGridButtons;

import learn.words.views.elements.buttons.gridButton.OpenNewWindowGridButtonOptions;
import learn.words.views.windows.MainWindow;
import learn.words.views.windows.TranslateWordWindow;

import javax.swing.*;
import java.awt.*;

public class CreateTranslateWordWindowButtons extends AbstractCreateWindowGridButtons {

    public CreateTranslateWordWindowButtons(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    public void createElements() {
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Перевести слово", 1, 1));
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Сохранить перевод", 3, 1));
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Следующий перевод", 1, 2));
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Предыдущий перевод", 3, 2));
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Очистить поле", 1, 3));
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new MainWindow(), frame, "В главное меню", 3, 3));

    }
}

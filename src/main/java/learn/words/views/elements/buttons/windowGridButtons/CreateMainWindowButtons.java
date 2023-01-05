package learn.words.views.elements.buttons.windowGridButtons;

import learn.words.views.options.buttonOptions.OpenNewWindowGridButtonOptions;
import learn.words.views.windows.TranslateWordWindow;

import javax.swing.*;
import java.awt.*;

public class CreateMainWindowButtons extends AbstractCreateWindowGridButtons {

    public CreateMainWindowButtons(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    public void createElements() {
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Добавить слово", 0, 0));
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Выучить новые слова", 1, 0));
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Повторить выученные слова", 0, 1));
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Посмотреть список слов", 1, 1));
    }
}

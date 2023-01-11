package learn.words.view.component.windowbuttons;

import learn.words.view.component.WindowButtonsBuilder;
import learn.words.view.option.button_option.OpenNewWindowGridButtonOptions;
import learn.words.view.window.RepeatWordWindow;
import learn.words.view.window.TranslateWordWindow;

import javax.swing.*;
import java.awt.*;

public class MainWindowButtons extends WindowButtonsBuilder {

    public MainWindowButtons(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    public void createElements() {
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Добавить слово", 0, 0));
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new RepeatWordWindow(), frame, "Выучить новые слова", 1, 0));
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new RepeatWordWindow(), frame, "Повторить выученные слова", 0, 1));
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new TranslateWordWindow(), frame, "Посмотреть список слов", 1, 1));
    }
}

package learn.words.views.elements.buttons.windowGridButtons;

import learn.words.views.options.buttonOptions.OpenNewWindowGridButtonOptions;
import learn.words.views.options.buttonOptions.TranslateWordButtonOptions;
import learn.words.views.windows.MainWindow;

import javax.swing.*;
import java.awt.*;

public class TranslateWordWindowButtons extends AbstractWindowGridButtons {
    private final JTextField inputTextField;
    private final JTextField disabledTextField;
    public TranslateWordWindowButtons(JFrame frame, Container pane, GridBagConstraints constraints,
                                      JTextField inputTextField, JTextField disabledTextField) {
        super(frame, pane, constraints);
        this.inputTextField = inputTextField;
        this.disabledTextField = disabledTextField;
    }

    @Override
    public void createElements() {
        createParticularElementOnPane(new TranslateWordButtonOptions(
                inputTextField, disabledTextField, "Перевести слово", 1, 1));
        createParticularElementOnPane(new TranslateWordButtonOptions(
                inputTextField, disabledTextField, "Сохранить перевод", 3, 1));
        createParticularElementOnPane(new TranslateWordButtonOptions(
                inputTextField, disabledTextField, "Очистить поле", 1, 2));
        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new MainWindow(), frame, "В главное меню", 3, 2));

    }
}

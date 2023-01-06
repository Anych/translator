package learn.words.views.elements.buttons.windowGridButtons;

import learn.words.views.options.buttonOptions.OpenNewWindowGridButtonOptions;
import learn.words.views.options.buttonOptions.TranslateWordButtonOptions;
import learn.words.views.windows.MainWindow;
import learn.words.views.windows.TranslateWordWindow;

import javax.swing.*;
import java.awt.*;

public class TranslateWordWindowButtons extends AbstractWindowGridButtons {
    private final JTextField inputTextField;
    private final JTextField disabledTextField;
    private final TranslateWordWindow window;
    public TranslateWordWindowButtons(TranslateWordWindow window, JFrame frame, Container pane,
                                      GridBagConstraints constraints,
                                      JTextField inputTextField, JTextField disabledTextField) {
        super(frame, pane, constraints);
        this.window = window;
        this.inputTextField = inputTextField;
        this.disabledTextField = disabledTextField;
    }

    @Override
    public void createElements() {
        createParticularElementOnPane(new TranslateWordButtonOptions(window,
                inputTextField, disabledTextField, "Перевести слово", 1, 1));

        createParticularElementOnPane(new TranslateWordButtonOptions(window,
                inputTextField, disabledTextField, "Сохранить перевод", 3, 1));

        createParticularElementOnPane(new TranslateWordButtonOptions(window,
                inputTextField, disabledTextField, "Очистить поле", 1, 2));

        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new MainWindow(), frame, "В главное меню", 3, 2));
    }
}

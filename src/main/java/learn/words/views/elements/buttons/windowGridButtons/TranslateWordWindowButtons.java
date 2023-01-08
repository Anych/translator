package learn.words.views.elements.buttons.windowGridButtons;

import learn.words.views.options.buttonOptions.OpenNewWindowGridButtonOptions;
import learn.words.views.options.buttonOptions.UseBothTextFieldsButtonOptions;
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
        createParticularElementOnPane(new UseBothTextFieldsButtonOptions(window,
                inputTextField, disabledTextField, "Перевести слово", 1, 1));

        createParticularElementOnPane(new UseBothTextFieldsButtonOptions(window,
                inputTextField, disabledTextField, "Сохранить", 3, 1));

        createParticularElementOnPane(new ChangeTranslationButtonOptions(window,
                disabledTextField, "Предыдущий перевод", 1, 2));

        createParticularElementOnPane(new ChangeTranslationButtonOptions(window,
                disabledTextField, "Следующий перевод", 3, 2));

        createParticularElementOnPane(new UseBothTextFieldsButtonOptions(window,
                inputTextField, disabledTextField, "Очистить", 1, 3));

        createParticularElementOnPane(new OpenNewWindowGridButtonOptions(
                new MainWindow(), frame, "В главное меню", 3, 3));
    }
}

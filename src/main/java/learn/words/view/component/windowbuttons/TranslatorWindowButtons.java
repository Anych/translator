package learn.words.view.component.windowbuttons;

import learn.words.view.component.WindowButtonsBuilder;
import learn.words.view.option.ChangeTranslationButtonOptions;
import learn.words.view.option.button_option.OpenNewWindowGridButtonOptions;
import learn.words.view.option.button_option.UseBothTextFieldsButtonOptions;
import learn.words.view.window.MainWindow;
import learn.words.view.window.TranslateWordWindow;

import javax.swing.*;
import java.awt.*;

public class TranslatorWindowButtons extends WindowButtonsBuilder {
    private final JTextField inputTextField;
    private final JTextField disabledTextField;
    private final TranslateWordWindow window;

    public TranslatorWindowButtons(TranslateWordWindow window, JFrame frame, Container pane,
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

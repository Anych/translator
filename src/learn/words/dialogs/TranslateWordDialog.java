package learn.words.dialogs;

import learn.words.buttons.GridButton;
import learn.words.buttons.GridButtonOptions;
import learn.words.textFields.TextField;

import javax.swing.*;
import java.awt.*;

public class TranslateWordDialog extends AbstractDialog {
    private GridBagConstraints constraints;
    private Container pane;
    private final Frame mainFrame;

    public TranslateWordDialog(Frame mainFrame) {
        this.frame = new JFrame("Переводчик");
        this.mainFrame = mainFrame;
    }

    @Override
    public void renderWindow() {
        setFrameOptions(750, 90);
        setPaneOptions();
        setConstraints();
        hideMainFrame();

        setButtonsListToCreate();
    }

    private void hideMainFrame() {
        mainFrame.setVisible(false);
    }

    private void setPaneOptions() {
        pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());
    }

    private void setConstraints() {
        this.constraints = new GridBagConstraints();
    }

    private void setButtonsListToCreate() {
        createParticularButtonOnPane(new GridButtonOptions(
                new TranslateWordDialog(frame), "Перевести слово", 0, 1));
        createParticularButtonOnPane(new GridButtonOptions(
                this, "Следующий перевод", 1, 1));
        createParticularButtonOnPane(new GridButtonOptions(
                this, "Предыдущий перевод", 2, 1));
        createParticularButtonOnPane(new GridButtonOptions(
                this, "Сохранить перевод", 3, 1));
        createParticularButtonOnPane(new GridButtonOptions(
                this, "В главное меню", 4, 1));
    }

    private void createParticularButtonOnPane(GridButtonOptions options) {
        GridButton button = setButtonOptions(options);
        button.render();
        button.create();
        button.onClick();

        pane.add(button.getButton(), constraints);
    }

    private GridButton setButtonOptions(GridButtonOptions options) {
        GridButton button = createButton();
        button.setConstraints(constraints);
        button.setButtonOptions(options);
        button.setOptionsFields();

        return button;
    }

    @Override
    protected GridButton createButton() {
        return new GridButton();
    }

    private TextField createTextField() {
        return new TextField();
    }
}

package learn.words.dialogs;

import learn.words.buttons.GridButton;
import learn.words.buttons.GridButtonOptions;
import javax.swing.*;
import java.awt.*;

public class MainDialog extends Dialog {
    private GridBagConstraints constraints;
    private Container pane;

    public MainDialog(String name) {
        super(name);
    }

    @Override
    public void renderWindow() {
        setFrameOptions(400, 90);
        setPaneOptions();
        setConstraints();

        setButtonsListToCreate();
    }

    private void setPaneOptions() {
        pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());
    }

    private void setConstraints() {
        this.constraints = new GridBagConstraints();
    }

    private void setButtonsListToCreate() {
        createParticularButtonOnPane(new GridButtonOptions("Добавить слово", 0, 0));
        createParticularButtonOnPane(new GridButtonOptions("Выучить новые слова", 1, 0));
        createParticularButtonOnPane(new GridButtonOptions("Повторить выученные слова", 0, 1));
        createParticularButtonOnPane(new GridButtonOptions("Посмотреть список слов", 1, 1));
    }

    private void createParticularButtonOnPane(GridButtonOptions options) {
        GridButton button = setButtonOptions(options);
        button.render();
        button.create();
        button.onClick(frame);

        pane.add(button.getButton(), constraints);
    }

    private GridButton setButtonOptions(GridButtonOptions options) {
        GridButton button = createButton();
        button.setConstraints(constraints);
        button.setButtonOptions(options);

        return button;
    }

    @Override
    protected GridButton createButton() {
        return new GridButton();
    }
}

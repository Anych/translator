package learn.words;

import javax.swing.*;
import java.awt.*;

public class MainDialog extends Dialog {

    private GridBagConstraints constraints;
    private Container pane;
    private final JFrame frame;

    public MainDialog(String name) {
        this.frame = new JFrame(name);
    }

    @Override
    public void renderWindow() {
        setFrameOptions();
        setPaneOptions();
        setConstraints();

        setButtonsListToCreate();
    }

    private void setFrameOptions() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 90);
        frame.setVisible(true);
        frame.setResizable(false);
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

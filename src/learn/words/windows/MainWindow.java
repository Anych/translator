package learn.words.windows;

import learn.words.buttons.windowGridButtons.MainWindowButtons;
import javax.swing.*;

public class MainWindow extends AbstractWindow {

    public MainWindow() {
        this.frame = new JFrame("Слова бегом");
    }

    @Override
    public void renderWindow() {
        setFrameOptions(400, 90);
        setPaneOptions();
        setConstraints();
    }

    @Override
    public void createElements() {
        MainWindowButtons buttons = new MainWindowButtons(frame, pane, constraints);
        buttons.createButtons();
    }
}

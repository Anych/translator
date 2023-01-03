package learn.words.windows;

import learn.words.buttons.windowGridButtons.MainWindowButtons;
import javax.swing.*;

public class MainWindow extends AbstractWindow {

    public MainWindow() {
        this.frame = new JFrame("Слова бегом");
    }

    @Override
    public void createElements() {
        MainWindowButtons buttons = new MainWindowButtons(frame, pane, constraints);
        buttons.createButtons();
    }

    @Override
    protected void setWindowSize() {
        frame.setSize(400, 90);
    }
}

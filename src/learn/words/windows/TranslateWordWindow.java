package learn.words.windows;

import learn.words.buttons.gridButton.GridButton;
import learn.words.buttons.gridButton.GridButtonOptions;
import learn.words.textFields.TextField;

import javax.swing.*;
import java.awt.*;

public class TranslateWordWindow extends AbstractWindow {
    private final Frame mainFrame;

    public TranslateWordWindow(Frame mainFrame) {
        this.frame = new JFrame("Переводчик");
        this.mainFrame = mainFrame;
    }

    @Override
    public void renderWindow() {
        setFrameOptions(750, 90);
        frame.setVisible(true);
        setPaneOptions();
        setConstraints();
        hideMainFrame();
    }

    private void hideMainFrame() {
        mainFrame.setVisible(false);
    }

    @Override
    public void createElements() {

    }

    private TextField createTextField() {
        return new TextField();
    }
}

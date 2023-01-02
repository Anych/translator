package learn.words.dialogs;

import learn.words.buttons.Button;

import javax.swing.*;
import java.awt.*;

public class TranslateWordDialog extends Dialog {
    private GridBagConstraints constraints;
    private Container pane;

    public TranslateWordDialog(String name) {
        super(name);
    }

    @Override
    public void renderWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public Button createButton() {
        return null;
    }
}

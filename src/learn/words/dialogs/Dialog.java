package learn.words.dialogs;

import learn.words.buttons.Button;

import javax.swing.*;

public abstract class Dialog {
    protected final JFrame frame;

    public Dialog(String name) {
        this.frame = new JFrame(name);
    }
    public abstract void renderWindow();

    protected void setFrameOptions(int width, int height) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    protected abstract Button createButton();
}

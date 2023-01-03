package learn.words.elements.buttons.actions;

import learn.words.windows.AbstractWindow;

import javax.swing.*;

public class OpenNewFrameAction implements AbstractAction {
    JFrame frame;
    AbstractWindow newWindow;

    public OpenNewFrameAction(JFrame frame, AbstractWindow newWindow) {
        this.frame = frame;
        this.newWindow = newWindow;
    }

    @Override
    public void executeCommand() {
        closeFrame();
        openNewWindow();
    }

    private void closeFrame() {
        frame.dispose();
    }

    private void openNewWindow() {
        newWindow.renderWindow();
        newWindow.createElements();
    }
}

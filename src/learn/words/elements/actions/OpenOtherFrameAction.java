package learn.words.elements.actions;

import learn.words.windows.AbstractWindow;

import javax.swing.*;

public class OpenOtherFrameAction implements AbstractAction {
    JFrame frame;
    AbstractWindow newWindow;

    public OpenOtherFrameAction(JFrame frame, AbstractWindow newWindow) {
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

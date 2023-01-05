package learn.words.views.elements.actions;

import learn.words.views.options.buttonOptions.OpenNewWindowGridButtonOptions;
import learn.words.views.windows.AbstractWindow;

import javax.swing.*;

public class OpenOtherFrameAction implements AbstractAction {
    OpenNewWindowGridButtonOptions options;

    public OpenOtherFrameAction(OpenNewWindowGridButtonOptions options) {
        this.options = options;
    }

    @Override
    public void executeCommand() {
        closeFrame();
        openNewWindow();
    }

    private void closeFrame() {
        options.getFrame().dispose();
    }

    private void openNewWindow() {
        options.getNewFrame().renderWindow();
        options.getNewFrame().createElements();
    }
}

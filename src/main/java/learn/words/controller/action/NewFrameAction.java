package learn.words.controller.action;

import learn.words.view.option.button_option.OpenNewWindowGridButtonOptions;

public class NewFrameAction implements AbstractAction {
    OpenNewWindowGridButtonOptions options;

    public NewFrameAction(OpenNewWindowGridButtonOptions options) {
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
        options.getNewFrame().renderWindow(false);
        options.getNewFrame().createElements();
    }
}

package learn.words.controllers.actions;

import learn.words.views.options.buttonOptions.OpenNewWindowGridButtonOptions;

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
        options.getNewFrame().renderWindow();
        options.getNewFrame().createElements();
    }
}

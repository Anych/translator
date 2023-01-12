package learn.words.controller.action;

import learn.words.view.option.GridButtonOptions;

public class NewWindowAction implements ActionFactory {
    GridButtonOptions options;

    public NewWindowAction(GridButtonOptions options) {
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

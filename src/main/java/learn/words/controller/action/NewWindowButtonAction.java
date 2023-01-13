package learn.words.controller.action;

import learn.words.view.option.GridButtonOptions;

public class NewWindowButtonAction implements ActionFactory {
    GridButtonOptions options;

    public NewWindowButtonAction(GridButtonOptions options) {
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
        options.getNewFrame().createWindow();
    }
}

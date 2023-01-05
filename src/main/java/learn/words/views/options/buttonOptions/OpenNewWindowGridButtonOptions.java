package learn.words.views.options.buttonOptions;

import learn.words.views.windows.AbstractWindow;

import javax.swing.*;

public final class OpenNewWindowGridButtonOptions extends AbstractGridButtonOptions {
    private final AbstractWindow newFrame;
    private final JFrame frame;

    public OpenNewWindowGridButtonOptions(AbstractWindow newFrame, JFrame frame,
                                          String buttonName, int gridX, int gridY) {
        super(buttonName, gridX, gridY);
        this.newFrame = newFrame;
        this.frame = frame;
    }

    public AbstractWindow getNewFrame() {
        return newFrame;
    }

    public JFrame getFrame() {
        return frame;
    }
}
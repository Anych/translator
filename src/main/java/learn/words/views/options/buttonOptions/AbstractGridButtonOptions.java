package learn.words.views.options.buttonOptions;

import learn.words.views.options.AbstractGridOptions;

public class AbstractGridButtonOptions extends AbstractGridOptions {
    protected final String buttonName;

    public AbstractGridButtonOptions(String buttonName, int gridX, int gridY) {
        super(gridX, gridY);
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}

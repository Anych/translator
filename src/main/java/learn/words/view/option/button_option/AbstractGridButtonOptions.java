package learn.words.view.option.button_option;

import learn.words.view.option.AbstractGridOptions;

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

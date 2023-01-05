package learn.words.views.options.textFieldsOptions;

import learn.words.views.options.AbstractGridOptions;

public class GridTextFieldOptions extends AbstractGridOptions {
    private final boolean isEditable;

    public GridTextFieldOptions(int gridX, int gridY, boolean isEditable) {
        super(gridX, gridY);
        this.isEditable = isEditable;
    }

    public boolean isEditable() {
        return isEditable;
    }
}
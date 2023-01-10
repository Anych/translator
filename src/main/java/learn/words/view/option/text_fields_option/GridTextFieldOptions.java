package learn.words.view.option.text_fields_option;

import learn.words.view.option.AbstractGridOptions;

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
package learn.words.view.element;

import learn.words.view.option.AbstractGridOptions;

import java.awt.*;

public abstract class ElementFactory {
    protected GridBagConstraints constraints;
    protected abstract void render();
    protected abstract void create();

    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }
    public abstract void setOptions(AbstractGridOptions options);
}

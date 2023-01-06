package learn.words.views.elements;

import learn.words.views.options.AbstractGridOptions;

import java.awt.*;

public abstract class AbstractParticularElement {
    protected GridBagConstraints constraints;
    protected abstract void render();
    protected abstract void create();

    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }
    public abstract void setOptions(AbstractGridOptions options);
}

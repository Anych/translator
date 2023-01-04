package learn.words.views.elements;

import java.awt.*;

public abstract class AbstractElement {
    protected GridBagConstraints constraints;
    protected abstract void render();
    protected abstract void create();

    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }
    public abstract void setOptions(Record options);
}

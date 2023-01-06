package learn.words.views.elements;

import learn.words.views.options.AbstractGridOptions;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractElements {
    protected JFrame frame;
    protected Container pane;
    protected GridBagConstraints constraints;

    public AbstractElements(JFrame frame, Container pane, GridBagConstraints constraints) {
        this.frame = frame;
        this.pane = pane;
        this.constraints = constraints;
    }

    public abstract void createElements();
    protected abstract JComponent createParticularElementOnPane(AbstractGridOptions options);
    protected abstract void setElementOptions(AbstractGridOptions options, AbstractParticularElement element);
}

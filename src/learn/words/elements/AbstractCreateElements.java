package learn.words.elements;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractCreateElements {
    protected JFrame frame;
    protected Container pane;
    protected GridBagConstraints constraints;

    public AbstractCreateElements(JFrame frame, Container pane, GridBagConstraints constraints) {
        this.frame = frame;
        this.pane = pane;
        this.constraints = constraints;
    }

    public abstract void createElements();
    protected abstract void createParticularElementOnPane(Record options);
    protected abstract void setElementOptions(Record options, AbstractElement element);
}

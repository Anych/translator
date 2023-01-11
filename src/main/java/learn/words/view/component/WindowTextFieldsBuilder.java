package learn.words.view.component;

import learn.words.view.element.ElementFactory;
import learn.words.view.option.AbstractGridOptions;

import javax.swing.*;
import java.awt.*;

public abstract class WindowTextFieldsBuilder implements CreateComponentsFactory {
    protected JFrame frame;
    protected Container pane;
    protected GridBagConstraints constraints;

    public WindowTextFieldsBuilder(JFrame frame, Container pane, GridBagConstraints constraints) {
        this.frame = frame;
        this.pane = pane;
        this.constraints = constraints;
    }

    @Override
    public void setElementOptions(AbstractGridOptions options, ElementFactory element) {
        element.setConstraints(constraints);
        element.setOptions(options);
    }
}

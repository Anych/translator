package learn.words.view.component;

import learn.words.view.element.ElementFactory;
import learn.words.view.option.AbstractGridOptions;

import javax.swing.*;

public interface CreateComponentsFactory {
    void createElements();
    JComponent createParticularElementOnPane(AbstractGridOptions options);
    void setElementOptions(AbstractGridOptions options, ElementFactory element);
}

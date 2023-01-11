package learn.words.view.element;

import learn.words.view.option.AbstractGridOptions;

import javax.swing.*;

public interface ComponentsFactory {
    void createElements();
    JComponent createParticularElementOnPane(AbstractGridOptions options);
    void setElementOptions(AbstractGridOptions options, AbstractParticularElement element);
}

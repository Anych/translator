package learn.words.view.element;

import javax.swing.*;

public interface ElementFactory {
    JComponent create();
    void render();
    void onClick();
    JComponent createComponent();
    JComponent getComponent();
}

package learn.words.view.element.button;

import learn.words.view.option.GridButtonOptions;

import javax.swing.*;
import java.awt.*;

public class ImageButtonFactory extends GridButtonFactory {
    public ImageButtonFactory(GridBagConstraints constraints, Container pane, GridButtonOptions options) {
        super(constraints, pane, options);
        pane.add(button, constraints);
        button.setPreferredSize(new Dimension(27, 27));
    }

    @Override
    public JButton createComponent() {
        return new JButton(new ImageIcon("src/main/resources/images/" + options.getButtonName() + ".jpg"));
    }
}

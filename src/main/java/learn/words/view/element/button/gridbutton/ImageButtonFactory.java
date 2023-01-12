package learn.words.view.element.button.gridbutton;

import javax.swing.*;
import java.awt.*;

public class ImageButtonFactory extends GridButtonFactory {
    @Override
    public void create() {
        button = new JButton(new ImageIcon("src/main/resources/images/" + options.getButtonName() + ".jpg"));
        button.setPreferredSize(new Dimension(27, 27));
    }
}

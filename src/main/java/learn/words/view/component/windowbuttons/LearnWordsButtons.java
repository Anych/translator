package learn.words.view.component.windowbuttons;

import learn.words.view.component.WindowButtonsBuilder;
import learn.words.view.element.button.gridbutton.GridButtonFactory;
import learn.words.view.element.button.gridbutton.ImageButtonFactory;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.option.buttonoption.ButtonWithImageOptions;

import javax.swing.*;
import java.awt.*;

public class LearnWordsButtons extends WindowButtonsBuilder {
    public JTextField learningWordField;
    public JTextField translateOfLearningWordField;

    public LearnWordsButtons(JFrame frame, Container pane, GridBagConstraints constraints,
                             JTextField learningWordField, JTextField translateOfLearningWordField) {
        super(frame, pane, constraints);
        this.learningWordField = learningWordField;
        this.translateOfLearningWordField = translateOfLearningWordField;
    }

    @Override
    public void createElements() {
        createParticularElementOnPane(
                new ButtonWithImageOptions(3, 0, "exit"));
        createParticularElementOnPane(
                new ButtonWithImageOptions(3, 1, "save"));
    }

    @Override
    public JButton createParticularElementOnPane(AbstractGridOptions options) {
        GridButtonFactory button = new ImageButtonFactory();
        setElementOptions(options, button);

        button.render();
        button.create();
        button.onClick();

        pane.add(button.getButton(), constraints);

        return button.getButton();
    }
}

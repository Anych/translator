package learn.words.view.element.text_field.window_text_field;

import learn.words.view.element.AbstractParticularElement;
import learn.words.view.element.ComponentsFactory;
import learn.words.view.element.text_field.grid_text_field.RepeatGridTextField;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.option.text_fields_option.RepeatTextFieldOptions;

import javax.swing.*;
import java.awt.*;

public class LearnWordsTextFields implements ComponentsFactory {
    protected JFrame frame;
    protected Container pane;
    protected GridBagConstraints constraints;
    public JTextField learningWord;
    public JTextField translateOfLearningWord;

    public LearnWordsTextFields(JFrame frame, Container pane, GridBagConstraints constraints) {
        this.frame = frame;
        this.pane = pane;
        this.constraints = constraints;
    }

    @Override
    public void createElements() {
        learningWord = createParticularElementOnPane(
                new RepeatTextFieldOptions(0, 0, frame, Color.YELLOW));
        translateOfLearningWord = createParticularElementOnPane(
                new RepeatTextFieldOptions(0, 1, frame, Color.WHITE));
    }

    @Override
    public JTextField createParticularElementOnPane(AbstractGridOptions options) {
        RepeatGridTextField repeatGridTextField = new RepeatGridTextField();
        setElementOptions(options, repeatGridTextField);

        repeatGridTextField.render();
        repeatGridTextField.create();

        pane.add(repeatGridTextField.getTextField(), constraints);

        return repeatGridTextField.getTextField();
    }

    @Override
    public void setElementOptions(AbstractGridOptions options, AbstractParticularElement element) {
        element.setConstraints(constraints);
        element.setOptions(options);
    }

    public JTextField getLearningWord() {
        return learningWord;
    }

    public JTextField getTranslateOfLearningWord() {
        return translateOfLearningWord;
    }
}

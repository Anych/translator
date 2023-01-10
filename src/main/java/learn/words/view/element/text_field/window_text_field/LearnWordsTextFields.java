package learn.words.view.element.text_field.window_text_field;

import learn.words.view.element.AbstractElements;
import learn.words.view.element.text_field.grid_text_field.RepeatGridTextField;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.option.text_fields_option.GridTextFieldOptions;
import learn.words.view.option.text_fields_option.RepeatTextFieldOptions;

import javax.swing.*;
import java.awt.*;

public class LearnWordsTextFields extends AbstractElements {
    public JTextField learningWord;
    public JTextField translateOfLearningWord;


    public LearnWordsTextFields(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    public void createElements() {
        learningWord = createParticularElementOnPane(new RepeatTextFieldOptions(0, 0));
        translateOfLearningWord = createParticularElementOnPane(new RepeatTextFieldOptions(0, 1));
    }

    @Override
    protected JTextField createParticularElementOnPane(AbstractGridOptions options) {
        RepeatGridTextField repeatGridTextField = new RepeatGridTextField();
        setElementOptions(options, repeatGridTextField);

        repeatGridTextField.render();
        repeatGridTextField.create();

        pane.add(repeatGridTextField.getTextField(), constraints);

        return repeatGridTextField.getTextField();
    }
}

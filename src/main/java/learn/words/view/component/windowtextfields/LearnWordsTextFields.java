package learn.words.view.component.windowtextfields;

import learn.words.view.component.WindowTextFieldsBuilder;
import learn.words.view.element.ElementFactory;
import learn.words.view.element.textfield.gridtextfield.RepeatGridTextField;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.option.textfieldoption.GridTextFieldOptions;

import javax.swing.*;
import java.awt.*;

public class LearnWordsTextFields extends WindowTextFieldsBuilder {
    public JTextField learningWord;
    public JTextField translateOfLearningWord;

    public LearnWordsTextFields(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    public void createElements() {
        learningWord = createParticularElementOnPane(
                new GridTextFieldOptions(frame, Color.YELLOW, 0, 0));
        translateOfLearningWord = createParticularElementOnPane(
                new GridTextFieldOptions(frame, Color.WHITE, 0, 0));
    }

    @Override
    public JTextField createParticularElementOnPane(AbstractGridOptions options) {
        RepeatGridTextField repeatGridTextField = new RepeatGridTextField();
        setElementOptions(options, repeatGridTextField);

        repeatGridTextField.render();
        repeatGridTextField.create();
        repeatGridTextField.onClick();

        pane.add(repeatGridTextField.getTextField(), constraints);

        return repeatGridTextField.getTextField();
    }

    @Override
    public void setElementOptions(AbstractGridOptions options, ElementFactory element) {
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

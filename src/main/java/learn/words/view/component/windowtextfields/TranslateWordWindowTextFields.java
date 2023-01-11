package learn.words.view.component.windowtextfields;

import learn.words.view.component.WindowTextFieldsBuilder;
import learn.words.view.element.ElementFactory;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.option.textfieldoption.GridTextFieldOptions;
import learn.words.view.element.textfield.gridtextfield.GridTextField;

import javax.swing.*;
import java.awt.*;

public class TranslateWordWindowTextFields extends WindowTextFieldsBuilder {
    private JTextField inputTextField;
    private JTextField disabledTextField;

    public TranslateWordWindowTextFields(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    public void createElements() {
        inputTextField = createParticularElementOnPane(new GridTextFieldOptions(0, 0, true));
        disabledTextField = createParticularElementOnPane(new GridTextFieldOptions(3, 0, false));
    }

    @Override
    public JTextField createParticularElementOnPane(AbstractGridOptions options) {
        GridTextField gridTextField = new GridTextField();
        setElementOptions(options, gridTextField);

        gridTextField.render();
        gridTextField.create();

        pane.add(gridTextField.getTextField(), constraints);

        return gridTextField.getTextField();
    }

    @Override
    public void setElementOptions(AbstractGridOptions options, ElementFactory element) {
        element.setConstraints(constraints);
        element.setOptions(options);
    }

    public JTextField getDisabledTextField() {
        return disabledTextField;
    }

    public JTextField getInputTextField() {
        return inputTextField;
    }
}

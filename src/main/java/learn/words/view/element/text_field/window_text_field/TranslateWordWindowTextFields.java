package learn.words.view.element.text_field.window_text_field;

import learn.words.view.element.AbstractParticularElement;
import learn.words.view.element.ComponentsFactory;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.option.text_fields_option.GridTextFieldOptions;
import learn.words.view.element.text_field.grid_text_field.GridTextField;

import javax.swing.*;
import java.awt.*;

public class TranslateWordWindowTextFields implements ComponentsFactory {
    protected JFrame frame;
    protected Container pane;
    protected GridBagConstraints constraints;
    public JTextField inputTextField;
    public JTextField disabledTextField;

    public TranslateWordWindowTextFields(JFrame frame, Container pane, GridBagConstraints constraints) {
        this.frame = frame;
        this.pane = pane;
        this.constraints = constraints;
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
    public void setElementOptions(AbstractGridOptions options, AbstractParticularElement element) {
        element.setConstraints(constraints);
        element.setOptions(options);
    }
}

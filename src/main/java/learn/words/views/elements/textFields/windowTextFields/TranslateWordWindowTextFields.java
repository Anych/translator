package learn.words.views.elements.textFields.windowTextFields;

import learn.words.views.elements.AbstractElements;
import learn.words.views.options.AbstractGridOptions;
import learn.words.views.options.textFieldsOptions.GridTextFieldOptions;
import learn.words.views.elements.textFields.gridTextField.GridTextField;

import javax.swing.*;
import java.awt.*;

public class TranslateWordWindowTextFields extends AbstractElements {
    public JTextField inputTextField;
    public JTextField disabledTextField;
    public TranslateWordWindowTextFields(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    public void createElements() {
        inputTextField = createParticularElementOnPane(new GridTextFieldOptions(0, 0, true));
        disabledTextField = createParticularElementOnPane(new GridTextFieldOptions(2, 0, false));
    }

    @Override
    protected JTextField createParticularElementOnPane(AbstractGridOptions options) {
        GridTextField gridTextField = new GridTextField();
        setElementOptions(options, gridTextField);

        gridTextField.render();
        gridTextField.create();

        pane.add(gridTextField.getTextField(), constraints);

        return gridTextField.getTextField();
    }
}

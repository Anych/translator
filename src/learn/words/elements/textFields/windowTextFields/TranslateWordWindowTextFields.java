package learn.words.elements.textFields.windowTextFields;

import learn.words.elements.textFields.gridTextField.GridTextField;
import learn.words.elements.textFields.gridTextField.GridTextOptions;
import javax.swing.*;
import java.awt.*;

public class TranslateWordWindowTextFields {
    protected JFrame frame;
    protected Container pane;
    protected GridBagConstraints constraints;

    public TranslateWordWindowTextFields(JFrame frame, Container pane, GridBagConstraints constraints) {
        this.frame = frame;
        this.pane = pane;
        this.constraints = constraints;
    }

    public void createTextFields() {
        createParticularTextFieldOnPane(new GridTextOptions(0, 0));
        createParticularTextFieldOnPane(new GridTextOptions(0, 1));
    }

    protected void createParticularTextFieldOnPane(GridTextOptions options) {
        GridTextField gridTextField = new GridTextField();
        setTextFieldOptions(options, gridTextField);

        gridTextField.render();
        gridTextField.create();

        pane.add(gridTextField.getTextField(), constraints);
    }

    protected void setTextFieldOptions(GridTextOptions options, GridTextField gridTextField) {
        gridTextField.setConstraints(constraints);
        gridTextField.setOptions(options);
        gridTextField.setRecordFields();
    }
}

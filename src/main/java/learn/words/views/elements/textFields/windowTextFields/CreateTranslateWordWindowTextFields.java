package learn.words.views.elements.textFields.windowTextFields;

import learn.words.views.elements.AbstractCreateElements;
import learn.words.views.elements.AbstractElement;
import learn.words.views.elements.textFields.GridTextFieldOptions;
import learn.words.views.elements.textFields.gridTextField.GridTextField;

import javax.swing.*;
import java.awt.*;

public class CreateTranslateWordWindowTextFields extends AbstractCreateElements {

    public CreateTranslateWordWindowTextFields(JFrame frame, Container pane, GridBagConstraints constraints) {
        super(frame, pane, constraints);
    }

    @Override
    public void createElements() {
        createParticularElementOnPane(new GridTextFieldOptions(0, 0, true));
        createParticularElementOnPane(new GridTextFieldOptions(2, 0, false));
    }

    @Override
    protected void createParticularElementOnPane(Record options) {
        GridTextField gridTextField = new GridTextField();
        setElementOptions(options, gridTextField);

        gridTextField.render();
        gridTextField.create();

        pane.add(gridTextField.getTextField(), constraints);
    }

    @Override
    protected void setElementOptions(Record options, AbstractElement gridTextField) {
        gridTextField.setConstraints(constraints);
        gridTextField.setOptions(options);
    }
}

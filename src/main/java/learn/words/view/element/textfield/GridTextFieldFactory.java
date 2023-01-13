package learn.words.view.element.textfield;

import learn.words.view.element.ElementFactory;
import learn.words.view.option.GridTextFieldOptions;

import javax.swing.*;
import java.awt.*;

public class GridTextFieldFactory implements ElementFactory {
    GridBagConstraints constraints;
    GridTextFieldOptions options;
    JTextField textField;

    public GridTextFieldFactory(GridBagConstraints constraints, Container pane, GridTextFieldOptions options) {
        this.constraints = constraints;
        this.options = options;
        this.textField = create();
        setEditable();
        onClick();
        pane.add(textField, constraints);
    }

    @Override
    public JTextField create() {
        render();
        return createComponent();
    }

    @Override
    public void render() {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = options.getGridX();
        constraints.gridy = options.getGridY();
        constraints.gridwidth = 2;
    }

    @Override
    public void onClick() {

    }

    private void setEditable() {
        textField.setEditable(options.isEditable());
    }

    @Override
    public JTextField createComponent() {
        return new JTextField(30);
    }

    @Override
    public JTextField getComponent() {
        return textField;
    }

    public JTextField getTextField() {
        return textField;
    }
}

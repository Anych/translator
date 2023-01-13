package learn.words.view.element.textfield;

import learn.words.controller.action.learnwindowactions.FrameDragListener;
import learn.words.view.element.ElementFactory;
import learn.words.view.option.GridTextFieldOptions;

import javax.swing.*;
import java.awt.*;

public class LearnGridTextFieldFactory implements ElementFactory {
    GridBagConstraints constraints;
    GridTextFieldOptions options;
    JTextField textField;

    public LearnGridTextFieldFactory(GridBagConstraints constraints, Container pane,
                                     GridTextFieldOptions options) {
        this.constraints = constraints;
        this.options = options;
        this.textField = create();
        changeTextFieldOptions();
        onClick();
        setEditable();
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
        Runnable runnable = () -> {
            FrameDragListener frameDragListener = new FrameDragListener(options.getFrame());
            textField.addMouseListener(frameDragListener);
            textField.addMouseMotionListener(frameDragListener);
        };
        SwingUtilities.invokeLater(runnable);
    }

    private void setEditable() {
        textField.setEditable(options.isEditable());
    }

    @Override
    public JTextField createComponent() {
        return new JTextField(30);
    }

    private void changeTextFieldOptions() {
        textField.setBackground(options.getColor());
        textField.setFont(new Font("Serif", Font.BOLD,20));
        textField.setBorder(null);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
    }

    @Override
    public JTextField getComponent() {
        return textField;
    }
}

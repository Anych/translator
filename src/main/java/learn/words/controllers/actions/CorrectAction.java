package learn.words.controllers.actions;


import learn.words.controllers.actions.translateWordWindow.*;
import learn.words.views.elements.buttons.windowGridButtons.ChangeTranslationButtonOptions;
import learn.words.views.options.AbstractGridOptions;
import learn.words.views.options.buttonOptions.OpenNewWindowGridButtonOptions;
import learn.words.views.options.buttonOptions.UseBothTextFieldsButtonOptions;

public class CorrectAction implements AbstractAction {
    private AbstractGridOptions options;
    private AbstractAction action;

    public CorrectAction(AbstractGridOptions options) {
        this.options = options;
    }

    public void chooseCorrectAction() {
        String optionsName = getOptionsName();

        if ("UseBothTextFieldsButtonOptions".equals(optionsName)) {
            if (((UseBothTextFieldsButtonOptions) options).getButtonName().equals("Очистить")) {
                action = new CleanWindowAction((UseBothTextFieldsButtonOptions) options);
            } else if (((UseBothTextFieldsButtonOptions) options).getButtonName().equals("Сохранить")) {
                action = new SaveWordAction((UseBothTextFieldsButtonOptions) options);
            } else {
                action = new TranslateWordAction((UseBothTextFieldsButtonOptions) options);
            }

        } else if ("ChangeTranslationButtonOptions".equals(optionsName)) {
            action = new ChangeTranslationAction((ChangeTranslationButtonOptions) options);
        } else {
            action = new NewFrameAction((OpenNewWindowGridButtonOptions) options);
        }
    }

    private String getOptionsName() {
        return options.getClass().getSimpleName();
    }

    @Override
    public void executeCommand() {
        action.executeCommand();
    }
}

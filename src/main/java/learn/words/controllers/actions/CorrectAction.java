package learn.words.controllers.actions;


import learn.words.controllers.actions.translateWordWindow.ChangeTranslationAction;
import learn.words.controllers.actions.translateWordWindow.CleanWindowAction;
import learn.words.controllers.actions.translateWordWindow.TranslateWordAction;
import learn.words.views.elements.buttons.windowGridButtons.ChangeTranslationButtonOptions;
import learn.words.views.options.AbstractGridOptions;
import learn.words.views.options.buttonOptions.OpenNewWindowGridButtonOptions;
import learn.words.views.options.buttonOptions.ChangeBothTextFieldsButtonOptions;

public class CorrectAction implements AbstractAction {
    private AbstractGridOptions options;
    private AbstractAction action;

    public CorrectAction(AbstractGridOptions options) {
        this.options = options;
    }

    public void chooseCorrectAction() {
        String optionsName = getOptionsName();

        if ("ChangeBothTextFieldsButtonOptions".equals(optionsName)) {
            if (((ChangeBothTextFieldsButtonOptions) options).getButtonName().equals("Очистить")) {
                action = new CleanWindowAction((ChangeBothTextFieldsButtonOptions) options);
            } else {
                action = new TranslateWordAction((ChangeBothTextFieldsButtonOptions) options);
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

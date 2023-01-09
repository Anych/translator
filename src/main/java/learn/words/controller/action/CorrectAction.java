package learn.words.controller.action;


import learn.words.controller.action.translate_word_window.*;
import learn.words.view.element.button.window_grid_button.ChangeTranslationButtonOptions;
import learn.words.view.option.AbstractGridOptions;
import learn.words.view.option.button_option.OpenNewWindowGridButtonOptions;
import learn.words.view.option.button_option.UseBothTextFieldsButtonOptions;

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

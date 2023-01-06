package learn.words.controllers.actions;


import learn.words.views.elements.buttons.windowGridButtons.ChangeTranslationButtonOptions;
import learn.words.views.options.AbstractGridOptions;
import learn.words.views.options.buttonOptions.OpenNewWindowGridButtonOptions;
import learn.words.views.options.buttonOptions.TranslateWordButtonOptions;

public class CorrectAction implements AbstractAction {
    private final AbstractGridOptions options;
    private AbstractAction action;

    public CorrectAction(AbstractGridOptions options) {
        this.options = options;
    }

    public void chooseCorrectAction() {
        String optionsName = getOptionsName();

        if ("TranslateWordButtonOptions".equals(optionsName)) {
            action = new TranslateWordAction((TranslateWordButtonOptions) options);
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

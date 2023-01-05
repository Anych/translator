package learn.words.views.elements.actions;


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
        } else {
            action = new OpenOtherFrameAction((OpenNewWindowGridButtonOptions) options);
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

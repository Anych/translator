package learn.words.controller.action;


import learn.words.controller.action.translatebuttons.*;
import learn.words.view.option.GridButtonOptions;

public class CorrectAction implements ActionFactory {
    private final GridButtonOptions options;
    private ActionFactory action;

    public CorrectAction(GridButtonOptions options) {
        this.options = options;
    }

    public void chooseCorrectAction() {
        String optionsName = options.getAction();

        switch (optionsName) {
            case "Очистить" -> action = new CleanButtonAction(options);
            case "Сохранить" -> action = new SaveButtonAction(options);
            case "Перевести слово" -> action = new TranslateButtonAction(options);
            case "ChangeTranslation" -> action = new ChangeTranslationButtonsAction(options);
            default -> action = new NewWindowAction(options);
        }
    }

    @Override
    public void executeCommand() {
        action.executeCommand();
    }
}

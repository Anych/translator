package learn.words.controller.action;


import learn.words.controller.action.learnwindowactions.LearnWordButtonAction;
import learn.words.controller.action.translatewindowactions.*;
import learn.words.view.option.GridButtonOptions;

public class ActionStrategy implements ActionFactory {
    private final GridButtonOptions options;
    private ActionFactory action;

    public ActionStrategy(GridButtonOptions options) {
        this.options = options;
    }

    public void chooseCorrectAction() {
        String optionsName = options.getAction();

        switch (optionsName) {
            case "Очистить" -> action = new CleanButtonAction(options);
            case "Сохранить" -> action = new SaveButtonAction(options);
            case "Перевести слово" -> action = new TranslateButtonAction(options);
            case "ChangeTranslation" -> action = new ChangeTranslationButtonsAction(options);
            case "save" -> action = new LearnWordButtonAction(options);
            default -> action = new NewWindowButtonAction(options);
        }
    }

    @Override
    public void executeCommand() {
        action.executeCommand();
    }
}

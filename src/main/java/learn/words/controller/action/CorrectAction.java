package learn.words.controller.action;


import learn.words.controller.action.translate_word_window.*;
import learn.words.view.option.buttonoption.GridButtonOptions;

public class CorrectAction implements ActionFactory {
    private final GridButtonOptions options;
    private ActionFactory action;

    public CorrectAction(GridButtonOptions options) {
        this.options = options;
    }

    public void chooseCorrectAction() {
        String optionsName = options.getAction();

        switch (optionsName) {
            case "Очистить" -> action = new CleanWindowAction(options);
            case "Сохранить" -> action = new SaveWordAction(options);
            case "Перевести слово" -> action = new TranslateWordAction(options);
            case "ChangeTranslation" -> action = new ChangeTranslationAction(options);
            default -> action = new NewWindowAction(options);
        }
    }

    @Override
    public void executeCommand() {
        action.executeCommand();
    }
}

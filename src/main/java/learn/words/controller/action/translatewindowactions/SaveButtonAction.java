package learn.words.controller.action.translatewindowactions;

import learn.words.controller.action.ActionFactory;
import learn.words.model.entity.Word;
import learn.words.model.entity.dao.WordDAOImpl;
import learn.words.view.option.GridButtonOptions;
import org.postgresql.util.PSQLException;

import java.sql.SQLException;

public class SaveButtonAction implements ActionFactory {
    private final GridButtonOptions options;

    public SaveButtonAction(GridButtonOptions options) {
        this.options = options;
    }

    @Override
    public void executeCommand() {
        boolean appropriate = isTranslateAppropriateWithCurrentWordInInputTextField();

        if (appropriate) {
            doOperationsInDB();
        }
    }

    private boolean isTranslateAppropriateWithCurrentWordInInputTextField() {
        return options.getTranslateWordWindow().getWordToTranslate().equals(getInputTextField());
    }

    private void doOperationsInDB() {
        try {
            Word word = createNewWordObject();
            createNewWordInDB(word);
            setDisabledTextField("Сохранено");

        } catch (PSQLException e) {
            setDisabledTextField("Слово уже существует");
        } catch (SQLException e) {
            setDisabledTextField("Сохранение не удалось");
        }
    }

    private Word createNewWordObject() {
        Word word = new Word();
        word.setEnglish(getInputTextField());
        word.setRussian(getDisabledTextField());

        return word;
    }

    private void createNewWordInDB(Word newWord) throws SQLException {
        WordDAOImpl wordDAO = new WordDAOImpl();
        wordDAO.add(newWord);
    }

    private String getInputTextField() {
        return options.getInputTextField().getText();
    }

    private String getDisabledTextField() {
        return options.getDisabledTextField().getText();
    }

    private void setDisabledTextField(String text) {
        options.getDisabledTextField().setText(text);
    }
}

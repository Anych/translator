package learn.words.controllers.actions.translateWordWindow;

import learn.words.controllers.DatabaseConnection;
import learn.words.controllers.actions.AbstractAction;
import learn.words.models.tables.NewWord;
import learn.words.models.tables.dao.ProgressDAOImpl;
import learn.words.models.tables.dao.WordDAOImpl;
import learn.words.views.options.buttonOptions.UseBothTextFieldsButtonOptions;

import java.sql.Connection;
import java.sql.SQLException;

public class SaveWordAction implements AbstractAction {
    private final UseBothTextFieldsButtonOptions options;

    public SaveWordAction(UseBothTextFieldsButtonOptions options) {
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
        return options.getWindow().getWordToTranslate().equals(getInputTextField());
    }

    private void doOperationsInDB() {
        Connection connection = DatabaseConnection.connect();
        try {
            NewWord word = createNewWordObject();
            int wordId = createNewWordInDB(word, connection);

            createWordProgress(wordId, connection);
            setDisabledTextField("Сохранено");

        } catch (SQLException e) {
            rollbackTransaction(connection);
            setDisabledTextField("Сохранение не удалось");
        } finally {
            DatabaseConnection.disconnect();
        }
    }

    private NewWord createNewWordObject() {
        NewWord newWord = new NewWord();
        newWord.setEnglish_word(getInputTextField());
        newWord.setRussian_word(getDisabledTextField());

        return newWord;
    }

    private int createNewWordInDB(NewWord newWord, Connection connection) throws SQLException {
        WordDAOImpl wordDAO = new WordDAOImpl(connection);
        return wordDAO.add(newWord);
    }

    private void createWordProgress(int id, Connection connection) throws SQLException {
        ProgressDAOImpl progressDAO = new ProgressDAOImpl(connection);
        progressDAO.add(id);
    }

    private void rollbackTransaction(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

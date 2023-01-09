package learn.words.controller.action.translate_word_window;

import learn.words.controller.DatabaseConnection;
import learn.words.controller.action.AbstractAction;
import learn.words.model.entity.Word;
import learn.words.model.entity.dao.ProgressDAOImpl;
import learn.words.model.entity.dao.WordDAOImpl;
import learn.words.view.option.button_option.UseBothTextFieldsButtonOptions;

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
            connection.setAutoCommit(false);
            Word word = createNewWordObject();
            int wordId = createNewWordInDB(word, connection);

            createWordProgress(wordId, connection);
            setDisabledTextField("Сохранено");
            connection.commit();

        } catch (SQLException e) {
            rollbackTransaction(connection);
            setDisabledTextField("Сохранение не удалось");
        } finally {
            DatabaseConnection.disconnect();
        }
    }

    private Word createNewWordObject() {
        Word word = new Word();
        word.setEnglish(getInputTextField());
        word.setRussian(getDisabledTextField());

        return word;
    }

    private int createNewWordInDB(Word newWord, Connection connection) throws SQLException {
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

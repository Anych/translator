package learn.words.models.tables.dao;

import learn.words.controllers.DatabaseConnection;
import learn.words.models.tables.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WordDAOImpl implements WordDAO {

    Connection connection = DatabaseConnection.connect();

    @Override
    public String add(Word word) throws SQLException {
        String query = "INSERT INTO words(english, russian) VALUES (?, ?)";
        PreparedStatement ps = getPreparedStatement(query);

        if (ps == null) {
            return "Сохранение не удалось";
        } else {
            ps.setString(1, word.getEnglish_word());
            ps.setString(2, word.getRussian_word());
            return "Сохранено";
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Word getWord(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Word> getWords() throws SQLException {
        return null;
    }

    @Override
    public void update(Word emp) throws SQLException {

    }

    private PreparedStatement getPreparedStatement(String query) {
        try {
            return connection.prepareStatement(query);
        } catch (SQLException e) {
            return null;
        }
    }
}

package learn.words.model.entity.dao;

import learn.words.controller.DatabaseConnection;
import learn.words.model.entity.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WordDAOImpl implements WordDAO {
    Connection connection = DatabaseConnection.connect();
    @Override
    public void add(Word newWord) throws SQLException {
        String query = "INSERT INTO words(english, russian) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, newWord.getEnglish());
        ps.setString(2, newWord.getRussian());
        ps.executeUpdate();
        DatabaseConnection.disconnect();
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
}

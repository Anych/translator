package learn.words.model.entity.dao;

import learn.words.model.entity.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WordDAOImpl implements WordDAO {
    Connection connection;

    public WordDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int add(Word newWord) {
        String query = "INSERT INTO words(english, russian) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, newWord.getEnglish());
            ps.setString(2, newWord.getRussian());
            System.out.println(ps);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
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
}

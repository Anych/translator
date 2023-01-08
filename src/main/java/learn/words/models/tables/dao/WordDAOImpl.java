package learn.words.models.tables.dao;

import learn.words.models.tables.NewWord;

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
    public int add(NewWord newWord) {
        String query = "INSERT INTO word(english, russian) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, newWord.getEnglish_word());
            ps.setString(2, newWord.getRussian_word());

            return ps.executeUpdate();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public NewWord getWord(int id) throws SQLException {
        return null;
    }

    @Override
    public List<NewWord> getWords() throws SQLException {
        return null;
    }

    @Override
    public void update(NewWord emp) throws SQLException {

    }
}

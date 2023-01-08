package learn.words.models.tables.dao;

import learn.words.models.tables.NewWord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProgressDAOImpl implements ProgressDAO {
    Connection connection;

    public ProgressDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(int id) {
        String query = "INSERT INTO progress(from_russian, from_english, word_id) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setBoolean(1, false);
            ps.setBoolean(2, false);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public NewWord getProgress(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(NewWord emp) throws SQLException {

    }
}

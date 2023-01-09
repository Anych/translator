package learn.words.model.entity.dao;

import learn.words.model.entity.Word;

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
        String query = "INSERT INTO progress(word_id) VALUES (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Word getProgress(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Word emp) throws SQLException {

    }
}

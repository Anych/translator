package learn.words.model.entity.dao;

import learn.words.model.entity.Word;

import java.sql.SQLException;

public interface ProgressDAO {
    void add(int id) throws SQLException;
    void delete(int id) throws SQLException;
    Word getProgress(int id) throws SQLException;
    void update(Word emp) throws SQLException;
}

package learn.words.models.tables.dao;

import learn.words.models.tables.NewWord;

import java.sql.SQLException;

public interface ProgressDAO {
    void add(int id) throws SQLException;
    void delete(int id) throws SQLException;
    NewWord getProgress(int id) throws SQLException;
    void update(NewWord emp) throws SQLException;
}

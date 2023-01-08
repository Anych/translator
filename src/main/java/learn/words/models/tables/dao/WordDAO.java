package learn.words.models.tables.dao;

import learn.words.models.tables.NewWord;

import java.sql.SQLException;
import java.util.List;

public interface WordDAO {
    int add(NewWord newWord) throws SQLException;
    void delete(int id) throws SQLException;
    NewWord getWord(int id) throws SQLException;
    List<NewWord> getWords() throws SQLException;
    void update(NewWord emp) throws SQLException;
}

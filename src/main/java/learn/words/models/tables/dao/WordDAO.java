package learn.words.models.tables.dao;

import learn.words.models.tables.Word;

import java.sql.SQLException;
import java.util.List;

public interface WordDAO {
    String add(Word word) throws SQLException;
    void delete(int id) throws SQLException;
    Word getWord(int id) throws SQLException;
    List<Word> getWords() throws SQLException;
    void update(Word emp) throws SQLException;
}

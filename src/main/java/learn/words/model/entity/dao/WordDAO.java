package learn.words.model.entity.dao;

import learn.words.model.entity.Word;

import java.sql.SQLException;
import java.util.List;

public interface WordDAO {
    int add(Word newWord) throws SQLException;
    void delete(int id) throws SQLException;
    Word getWord(int id) throws SQLException;
    List<Word> getWords() throws SQLException;
    void update(Word emp) throws SQLException;
}

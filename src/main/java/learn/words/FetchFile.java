package learn.words;

import learn.words.model.entity.Word;
import learn.words.model.entity.dao.WordDAOImpl;
import org.postgresql.util.PSQLException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class FetchFile {

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader br = getBufferedReader();

        readLines(br);
    }

    private static BufferedReader getBufferedReader() {
        try {
            String dictionary = "C:\\Users\\user\\Desktop\\Обучение\\NEF\\advanced\\словарь.txt";
            return new BufferedReader(new FileReader(dictionary));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readLines(BufferedReader br) throws IOException, SQLException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] wordPair = line.split(": ");

            String en = getWord(wordPair[0]);
            String ru = wordPair[1].substring(1, wordPair[1].length() - 2);

            Word word = createNewWordObject(en, ru);
            createNewWordInDB(word);
        }
    }

    private static String getWord(String word) {

        return word.substring(1, word.length() - 1);
    }


    private static Word createNewWordObject(String en, String ru) {
        Word word = new Word();
        word.setEnglish(en);
        word.setRussian(ru);

        return word;
    }

    private static void createNewWordInDB(Word newWord) throws SQLException {
        try {
            WordDAOImpl wordDAO = new WordDAOImpl();
            wordDAO.add(newWord);
        } catch (PSQLException e) {
            System.out.println(e);
        }
    }
}

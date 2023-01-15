package learn.words.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AllWords implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Map<String, String> allWords = new HashMap<>();

    public AllWords() {
    }

    public void addWord(String word, String translate) {
        allWords.put(word, translate);
    }

    public int getAllWordsSize() {
        return getAllWordsMap().size();
    }

    public Map<String, String> getAllWordsMap() {
        return allWords;
    }

    public void setAllWords(Map<String, String> words) {
        allWords.putAll(words);
    }

    @Override
    public String toString() {
        return "AllWords{" +
                "allWords=" + allWords +
                '}';
    }
}

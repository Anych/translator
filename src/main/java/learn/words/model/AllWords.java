package learn.words.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AllWords implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Map<String, String> allWords = new HashMap<>();

    public AllWords() {
    }

    public void addWord(String word, String translate) {
        allWords.put(word, translate);
    }

    @Override
    public String toString() {
        return "AllWords{" +
                "allWords=" + allWords +
                '}';
    }
}

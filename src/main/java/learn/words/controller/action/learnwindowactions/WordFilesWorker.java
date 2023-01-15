package learn.words.controller.action.learnwindowactions;

import learn.words.controller.FileWorker;
import learn.words.controller.RandomKey;

import java.util.Map;

public class WordFilesWorker {
    Map<String, String> learningWords;
    Map<String, String> learnedWords;
    Map<String, String> allWords;

    public Map<String, String> startExecution() {
        getWordsMap();
        addWordToMapIfNeed();
        FileWorker.writeNewWordsInFile("src/main/resources/files/learning.ser", learningWords);
        return learningWords;
    }

    private void getWordsMap() {
        allWords = FileWorker.getWords("src/main/resources/files/dictionary.ser").getAllWordsMap();
        learnedWords = FileWorker.getWords("src/main/resources/files/learned.ser").getAllWordsMap();
        learningWords = FileWorker.getWords("src/main/resources/files/learning.ser").getAllWordsMap();
    }

    private void addWordToMapIfNeed() {
        if (learningWords.size() < 50 && learnedWords.size() + learningWords.size() < allWords.size()) {
            String randomKey = RandomKey.getRandomKey(allWords);
            checkIfWordInLearned(randomKey);
        }
    }

    private void checkIfWordInLearned(String randomKey) {
        if (!learnedWords.containsKey(randomKey)) {
            String value = allWords.get(randomKey);
            learningWords.put(randomKey, value);
        }
        addWordToMapIfNeed();
    }
}

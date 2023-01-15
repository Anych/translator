package learn.words.controller.action.learnwindowactions;

import learn.words.controller.FileWorker;
import learn.words.controller.RandomKey;
import learn.words.model.AllWords;

import java.io.*;
import java.util.Map;

public class LearningWords {
    Map<String, String> learningWords;
    Map<String, String> learnedWords;
    Map<String, String> allWords;

    public Map<String, String> startExecution() {
        setAllWordsMap();
        addWordToMapIfNeed();
        writeNewWordsInFile();
        return learningWords;
    }

    private void setAllWordsMap() {
        allWords = getWords("src/main/resources/files/dictionary.ser").getAllWordsMap();
        learnedWords = getWords("src/main/resources/files/learned.ser").getAllWordsMap();
        learningWords = getWords("src/main/resources/files/learning.ser").getAllWordsMap();
    }

    public AllWords getWords(String path) {
        try (FileInputStream input = FileWorker.getFileInputStream(path)){
            ObjectInputStream objectInputStream = new ObjectInputStream(input);
            return (AllWords) objectInputStream.readObject();

        } catch (EOFException e) {
            return new AllWords();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
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

    private void writeNewWordsInFile() {
        try (FileOutputStream outputStream =
                     FileWorker.getFileOutputStream("src/main/resources/files/learning.ser")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            AllWords allWords = new AllWords();
            allWords.setAllWords(learningWords);
            objectOutputStream.writeObject(allWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

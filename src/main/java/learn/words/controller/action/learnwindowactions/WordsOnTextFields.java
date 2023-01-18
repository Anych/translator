package learn.words.controller.action.learnwindowactions;

import learn.words.controller.utility.RandomKey;

import javax.swing.*;
import java.util.Map;

public class WordsOnTextFields {
    private final JTextField learningWordField;
    private final JTextField translateOfLearningWordField;
    Map<String, String> learningWords;
    private String word;
    private String translate;

    public WordsOnTextFields(JTextField learningWordField, JTextField translateOfLearningWordField) {
        this.learningWordField = learningWordField;
        this.translateOfLearningWordField = translateOfLearningWordField;
    }

    public void startExecution() {
        setEmptyFields();
        prepareWords();

        if (learningWords.size() > 0) {
            getWords();
            setWords();
            continueExecution();
        } else {
            setTranslation("Все слова выучены");
        }
    }

    private void prepareWords() {
        learningWords = new WordFilesWorker().startExecution();
    }

    public void getWords() {
        getLearningWord();
        getTranslate();
    }

    private void getLearningWord() {
        word = RandomKey.getRandomKey(learningWords);
    }

    private void getTranslate() {
        translate = learningWords.get(word);
    }

    private void setWords() {
        if (!Thread.currentThread().isInterrupted()) {
            setLearningWord(word);
        }
        if (!Thread.currentThread().isInterrupted()) {
            waitTime();
        }
        if (!Thread.currentThread().isInterrupted()) {
            setTranslation(translate);
        }
    }

    private void setLearningWord(String word) {
        learningWordField.setText(word);
    }

    public void waitTime() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void setTranslation(String word) {
        translateOfLearningWordField.setText(word);
    }

    public void continueExecution() {
        if (!Thread.currentThread().isInterrupted()) {
            waitTime();
            setEmptyFields();
            startExecution();
        }
    }

    private void setEmptyFields() {
        setLearningWord("");
        setTranslation("");
    }

    public JTextField getLearningWordField() {
        return learningWordField;
    }

    public JTextField getTranslateOfLearningWordField() {
        return translateOfLearningWordField;
    }
}

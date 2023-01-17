package learn.words.controller.action.learnwindowactions;

import learn.words.controller.RandomKey;

import javax.swing.*;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.Consumer;

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
        prepareWords();
        if (learningWords.size() > 0) {
            getWords();
            setWords();
            if (!Thread.currentThread().isInterrupted()) {
                continueExecution();
            }
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
        if (!Thread.currentThread().isInterrupted()) {
            waitTime();
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

    private void continueExecution() {
        setEmptyFields();
        startExecution();
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

    public void asd() {
        System.out.println(Thread.currentThread().getName());
    }
}

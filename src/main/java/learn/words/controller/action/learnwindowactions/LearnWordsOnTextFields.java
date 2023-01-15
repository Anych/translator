package learn.words.controller.action.learnwindowactions;

import learn.words.controller.RandomKey;

import javax.swing.*;
import java.util.Map;

public class LearnWordsOnTextFields {
    private final JTextField learningWordField;
    private final JTextField translateOfLearningWordField;
    private JButton saveButton;
    Map<String, String> learningWords;
    private String word;
    private String translate;

    public LearnWordsOnTextFields(JTextField learningWordField, JTextField translateOfLearningWordField, JButton saveButton) {
        this.learningWordField = learningWordField;
        this.translateOfLearningWordField = translateOfLearningWordField;
        this.saveButton = saveButton;
        startExecution();
    }

    private void startExecution() {
        prepareWords();
        getWords();
        setWords();
        continueExecution();
    }

    private void prepareWords() {
        learningWords = new LearningWords().startExecution();
    }

    private void getWords() {
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
        setLearningWord(word);
        waitTime();
        setTranslation(translate);
        waitTime();
    }

    private void setLearningWord(String word) {
        learningWordField.setText(word);
    }

    private void setEmptyTranslationWord() {
        translateOfLearningWordField.setText("");
    }

    private void waitTime() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
}

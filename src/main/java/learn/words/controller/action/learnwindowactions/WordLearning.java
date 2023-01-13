package learn.words.controller.action.learnwindowactions;

import javax.swing.*;

public class WordLearning {
    JTextField learningWord;
    JTextField translateOfLearningWord;
    JButton saveButton;
    String exercise;

    public WordLearning(JTextField learningWord, JTextField translateOfLearningWord,
                        JButton saveButton, String exercise) {
        this.learningWord = learningWord;
        this.translateOfLearningWord = translateOfLearningWord;
        this.saveButton = saveButton;
        this.exercise = exercise;
        startExecution();
    }

    private void startExecution() {

    }
}

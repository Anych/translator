package learn.words.controller.action.learnwindowactions;

import learn.words.controller.FileWorker;
import learn.words.controller.action.ActionFactory;
import learn.words.view.option.GridButtonOptions;

import javax.swing.*;
import java.util.Map;

public class WordLearnedButtonAction implements ActionFactory {
    private final GridButtonOptions options;
    private final JTextField learningTextField;
    private final JTextField translateOfLearningWord;
    private WordsOnTextFields wordsOnTextFields;
    private final String learnedPath = "src/main/resources/files/learned.ser";
    Map<String, String> learningWords;
    Map<String, String> learnedWords;

    public WordLearnedButtonAction(GridButtonOptions options) {
        this.options = options;
        this.learningTextField = options.getWordsOnTextFields().getLearningWordField();
        this.translateOfLearningWord = options.getWordsOnTextFields().getTranslateOfLearningWordField();
        this.wordsOnTextFields = options.getWordsOnTextFields();
        this.learningWords = wordsOnTextFields.learningWords;
    }

    @Override
    public void executeCommand() {
        if (wereAllWordsLearn()) {
            Thread thread = prepareWordsOnTextFieldClass();

            saveWord();

            setTextFields();
            continueExecution(thread);
        }
    }

    private boolean wereAllWordsLearn() {
        String translate = learningTextField.getText();
        return !translate.equals("Все слова выучены");
    }

    private Thread prepareWordsOnTextFieldClass() {
        interruptWordsOnTextFieldThread();
        Thread thread = createWordsInTextFieldsInNewThread();
        setNewOptions(thread);
        return thread;
    }

    private void interruptWordsOnTextFieldThread() {
        options.getThread().interrupt();
    }

    private Thread createWordsInTextFieldsInNewThread() {
        wordsOnTextFields = new WordsOnTextFields(learningTextField, translateOfLearningWord);
        Runnable task = wordsOnTextFields::startExecution;
        return new Thread(task);
    }

    private void setNewOptions(Thread thread) {
        options.setWordsOnTextFields(wordsOnTextFields);
        options.setThread(thread);
    }

    private void saveWord() {
        getWordsMap();
        String word = saveWordInLearnedMap();
        addToLearnedFile();
        removeFromLearningMap(word);
    }
    private void getWordsMap() {
        learnedWords = FileWorker.getWords(learnedPath).getAllWordsMap();
    }

    private String saveWordInLearnedMap() {
        String word = getLearningWord();
        String translation = getTranslation(word);
        learnedWords.put(word, translation);
        return word;
    }

    private String getLearningWord() {
        return learningTextField.getText();
    }

    private String getTranslation(String word) {
        return learningWords.get(word);
    }

    private void addToLearnedFile() {
        FileWorker.writeNewWordsInFile(learnedPath, learnedWords);
    }

    private void removeFromLearningMap(String word) {
        learningWords.remove(word);
        FileWorker.writeNewWordsInFile("src/main/resources/files/learning.ser", learningWords);
    }

    private void setTextFields() {
        learningTextField.setText("");
        translateOfLearningWord.setText("Выучено");
    }

    private void continueExecution(Thread thread) {
        thread.start();
    }
}

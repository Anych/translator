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
    private Thread thread;

    public WordLearnedButtonAction(GridButtonOptions options) {
        this.options = options;
        this.learningTextField = options.getWordsOnTextFields().getLearningWordField();
        this.translateOfLearningWord = options.getWordsOnTextFields().getTranslateOfLearningWordField();
        this.wordsOnTextFields = options.getWordsOnTextFields();
        this.learningWords = wordsOnTextFields.learningWords;
    }

    @Override
    public void executeCommand() {
        if (wereNotAllWordsLearn()) {
            prepareWordsOnTextFieldClass();

            saveWord();
            setTextFields();
            continueExecution();
        }
    }

    private boolean wereNotAllWordsLearn() {
        String translate = learningTextField.getText();
        return !translate.equals("Все слова выучены");
    }

    private void prepareWordsOnTextFieldClass() {
        interruptWordsOnTextFieldThread();
        thread = createWordsInTextFieldsInNewThread();
        setNewOptions();
    }

    private void interruptWordsOnTextFieldThread() {
        options.getThread().interrupt();
    }

    private Thread createWordsInTextFieldsInNewThread() {
        wordsOnTextFields = new WordsOnTextFields(learningTextField, translateOfLearningWord);
        Runnable task = wordsOnTextFields::continueExecution;
        return new Thread(task);
    }

    private void setNewOptions() {
        options.setWordsOnTextFields(wordsOnTextFields);
        options.setThread(thread);
    }

    private void saveWord() {
        getWordsMap();
        String word = saveWordInLearnedMap();

        if (word.equals("None")) {
            translateOfLearningWord.setText("Дождитесь следующего слова");
        } else {
            addToLearnedFile();
            removeFromLearningMap(word);
        }
    }

    private void getWordsMap() {
        learnedWords = FileWorker.getWords(learnedPath).getAllWordsMap();
    }

    private String saveWordInLearnedMap() {
        String word = getLearningWord();
        String translation = getTranslation(word);
        if (translation.equals("None") || word.isEmpty()) {
            return "None";
        } else {
            learnedWords.put(word, translation);
            return word;
        }
    }

    private String getLearningWord() {
        return learningTextField.getText();
    }

    private String getTranslation(String word) {
        try {
            return learningWords.get(word);
        } catch (NullPointerException e) {
            return "None;";
        }
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
        if (!translateOfLearningWord.getText().equals("Дождитесь следующего слова")) {
            translateOfLearningWord.setText("Выучено");
        }
    }

    private void continueExecution() {
        thread.start();
    }
}

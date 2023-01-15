package learn.words.controller.action.learnwindowactions;

import learn.words.controller.FileWorker;
import learn.words.controller.action.ActionFactory;
import learn.words.view.option.GridButtonOptions;

import java.util.Map;

public class LearnWordButtonAction implements ActionFactory {
    private final GridButtonOptions options;
    Map<String, String> learningWords;
    Map<String, String> learnedWords;

    public LearnWordButtonAction(GridButtonOptions options) {
        this.options = options;
    }

    @Override
    public void executeCommand() {
        getWordsMap();
        String word = saveWordInLearnedMap();
        removeFromLearning(word);
        addToLearnedFile();
        setTextFields();
        options.getWordsOnTextFields().startExecution();
    }

    private String saveWordInLearnedMap() {
        String word = getLearningWord();
        String translation = getTranslation(word);
        learnedWords.put(word, translation);
        return word;
    }

    private String getLearningWord() {
        return options.getWordsOnTextFields().getLearningWordField().getText();
    }

    private String getTranslation(String word) {
        return learningWords.get(word);
    }

    private void getWordsMap() {
        learningWords = options.getWordsOnTextFields().learningWords;
        learnedWords = FileWorker.getWords("src/main/resources/files/learned.ser").getAllWordsMap();
    }

    private void removeFromLearning(String word) {
        learningWords.remove(word);
        FileWorker.writeNewWordsInFile("src/main/resources/files/learning.ser", learningWords);
    }

    private void addToLearnedFile() {
        FileWorker.writeNewWordsInFile("src/main/resources/files/learned.ser", learnedWords);
    }

    private void setTextFields() {
        options.getWordsOnTextFields().getLearningWordField().setText("");
        options.getWordsOnTextFields().getTranslateOfLearningWordField().setText("Выучено");
    }
}

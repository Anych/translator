package learn.words.controller.action.learnwindowactions;

import learn.words.controller.FileWorker;
import learn.words.controller.action.ActionFactory;
import learn.words.view.option.GridButtonOptions;

import java.util.Map;

public class WordLearnedButtonAction implements ActionFactory {
    private final GridButtonOptions options;
    private final String learnedPath = "src/main/resources/files/learned.ser";
    Map<String, String> learningWords;
    Map<String, String> learnedWords;

    public WordLearnedButtonAction(GridButtonOptions options) {
        this.options = options;
    }

    @Override
    public void executeCommand() {
        if (!options.getWordsOnTextFields().getTranslateOfLearningWordField().getText().equals("Все слова выучены")) {
            getWordsMap();
            String word = saveWordInLearnedMap();
            addToLearnedFile();
            removeFromLearningMap(word);
            setTextFields();
        }
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
        learnedWords = FileWorker.getWords(learnedPath).getAllWordsMap();
    }

    private void removeFromLearningMap(String word) {
        learningWords.remove(word);
        FileWorker.writeNewWordsInFile("src/main/resources/files/learning.ser", learningWords);
    }

    private void addToLearnedFile() {
        FileWorker.writeNewWordsInFile(learnedPath, learnedWords);
    }

    private void setTextFields() {
        options.getWordsOnTextFields().getLearningWordField().setText("");
        options.getWordsOnTextFields().getTranslateOfLearningWordField().setText("Выучено");
    }
}

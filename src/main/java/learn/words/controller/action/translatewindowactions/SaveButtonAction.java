package learn.words.controller.action.translatewindowactions;

import learn.words.controller.FileWorker;
import learn.words.controller.action.ActionFactory;
import learn.words.model.AllWords;
import learn.words.view.option.GridButtonOptions;

import java.io.*;

public class SaveButtonAction implements ActionFactory {
    private final GridButtonOptions options;
    private final String path = "src/main/resources/files/dictionary.ser";

    public SaveButtonAction(GridButtonOptions options) {
        this.options = options;
    }

    @Override
    public void executeCommand() {
        boolean appropriate = isTranslateAppropriateWithCurrentWordInInputTextField();

        if (appropriate) {
            saveWordInFile();
            setDisabledTextField("Сохранено");
        } else {
            setDisabledTextField("Слово для перевода изменилось");
        }
    }

    private void saveWordInFile() {
        AllWords allWords = getAllWords();
        addWordToAllWordsObject(allWords);
        writeObjectInFile(allWords);
    }

    private AllWords getAllWords() {
        try (FileInputStream input = FileWorker.getFileInputStream(path)){
            ObjectInputStream objectInputStream = new ObjectInputStream(input);
            return (AllWords) objectInputStream.readObject();

        } catch (IOException e) {
            return new AllWords();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void addWordToAllWordsObject(AllWords allWords) {
        allWords.addWord(getInputTextField(), getDisabledTextField());
    }

    private void writeObjectInFile(AllWords allWords) {
        try (FileOutputStream outputStream = FileWorker.getFileOutputStream(path)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(allWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isTranslateAppropriateWithCurrentWordInInputTextField() {
        return options.getTranslateWordWindow().getWordToTranslate().equals(getInputTextField());
    }

    private String getInputTextField() {
        return options.getInputTextField().getText();
    }

    private String getDisabledTextField() {
        return options.getDisabledTextField().getText();
    }

    private void setDisabledTextField(String text) {
        options.getDisabledTextField().setText(text);
    }
}

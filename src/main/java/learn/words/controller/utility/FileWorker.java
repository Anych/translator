package learn.words.controller.utility;

import learn.words.model.AllWords;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class FileWorker {

    public static Properties getProperties(String name) {
        java.util.Properties prop = new java.util.Properties();
        try (InputStream input = new FileInputStream(name)) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    public static FileOutputStream getFileOutputStream(String path) {
        try {
            return new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static FileInputStream getFileInputStream(String path) {
        try  {
            return new FileInputStream(path);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static AllWords getWords(String path) {
        try (FileInputStream input = FileWorker.getFileInputStream(path)){
            ObjectInputStream objectInputStream = new ObjectInputStream(input);
            return (AllWords) objectInputStream.readObject();

        } catch (EOFException e) {
            return new AllWords();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeNewWordsInFile(String path, Map<String, String> words) {
        try (FileOutputStream outputStream =
                     FileWorker.getFileOutputStream(path)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            AllWords allWords = new AllWords();
            allWords.setAllWords(words);
            objectOutputStream.writeObject(allWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package learn.words;

import learn.words.controller.FileWorker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class FetchFile {
    private static final String path = "src/main/resources/files/dictionary.ser";
    public static void main(String[] args) throws IOException {
        BufferedReader br = getBufferedReader();
        readLines(br);
    }

    private static BufferedReader getBufferedReader() {
        try {
            String dictionary = "C:\\Users\\user\\Desktop\\Обучение\\NEF\\advanced\\словарь.txt";
            return new BufferedReader(new FileReader(dictionary));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private static void readLines(BufferedReader br) throws IOException {
        String line;
        Map<String, String> map = FileWorker.getWords(path).getAllWordsMap();

        while ((line = br.readLine()) != null) {
            String[] wordPair = line.split(": ");

            String en = wordPair[0].substring(1, wordPair[0].length() - 1);
            String ru = wordPair[1].substring(1, wordPair[1].length() - 2);

            if (!map.containsKey(en)) {
                map.put(en, ru);
            }
        }

        FileWorker.writeNewWordsInFile(path, map);
    }
}

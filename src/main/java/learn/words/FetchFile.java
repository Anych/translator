package learn.words;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FetchFile {

    public static void main(String[] args) {
        BufferedReader br = getBufferedReader();

    }

    private static BufferedReader getBufferedReader() {
        try {
            String dictionary = "C:\\Users\\user\\Desktop\\Обучение\\NEF\\advanced\\словарь.txt";
            return new BufferedReader(new FileReader(dictionary));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

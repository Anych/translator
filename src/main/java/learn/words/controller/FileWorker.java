package learn.words.controller;

import learn.words.model.AllWords;

import java.io.*;
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
}

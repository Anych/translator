package learn.words.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    public static Properties getProperties(String name) {
        java.util.Properties prop = new java.util.Properties();
        try (InputStream input = new FileInputStream(name)) {
            prop.load(input);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }
}

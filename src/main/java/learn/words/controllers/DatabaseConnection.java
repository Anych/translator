package learn.words.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    static Connection connection;

    public static Connection connect() {
        Properties prop = PropertiesFile.getProperties("src/main/resources/db.properties");
        try {
            return connection = DriverManager.getConnection(prop.getProperty("URL"),
                    prop.getProperty("USER"), prop.getProperty("PASSWORD"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

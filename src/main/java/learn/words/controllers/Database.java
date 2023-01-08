package learn.words.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

    Connection connection;
    public void connect() {
        Properties prop = PropertiesFile.getProperties("src/main/resources/db.properties");
        boolean exists = isConnectionExists();

        if (!exists) {
            connection = getConnection(prop);
        }
    }

    private boolean isConnectionExists() {
        return connection != null;
    }

    private Connection getConnection(Properties prop) {
        try {
            return connection = DriverManager.getConnection(prop.getProperty("URL"),
                    prop.getProperty("USER"), prop.getProperty("PASSWORD"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Database db = new Database();
        db.connect();
        db.disconnect();
    }
}

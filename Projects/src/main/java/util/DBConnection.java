package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static final Properties properties = new Properties();
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/config/database.properties")) {
            properties.load(fileInputStream);
            driver = properties.getProperty("development.driver");
            url = properties.getProperty("development.url");
            username = properties.getProperty("development.username");
            password = properties.getProperty("development.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection connect(String database) throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return DriverManager.getConnection(url + database + "?createDatabaseIfNotExist=true", username, password);
    }
}
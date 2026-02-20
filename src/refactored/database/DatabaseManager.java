package refactored.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:sqlite:oministore.db";

    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("SQLite driver loaded.");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite driver NOT found!");
            e.printStackTrace();
        }

        System.out.println("Connecting to database...");
        return DriverManager.getConnection(URL);
    }
}



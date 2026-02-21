package refactored.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:sqlite:oministore.db";

    public static Connection connect() {
        try {
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(URL);
            System.out.println("Database connected successfully.");
            return connection;
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}


package refactored.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {

    public static void createTable() {

        String sql = "CREATE TABLE IF NOT EXISTS orders ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "customerName TEXT,"
                + "total REAL"
                + ");";

        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement()) {

            System.out.println("Connected to SQLite.");
            stmt.execute(sql);
            System.out.println("Table check complete!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


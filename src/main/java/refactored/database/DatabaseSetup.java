package refactored.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {

    public static void createTable() {

        String sql = """
            CREATE TABLE IF NOT EXISTS orders (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                description TEXT NOT NULL,
                cost INTEGER NOT NULL,
                payment_type TEXT NOT NULL
            );
        """;

        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Orders table ready.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package refactored.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {

    // Database file
    private static final String URL = "jdbc:sqlite:oministore.db";

    /**
     * Establish connection to SQLite database
     */
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

    /**
     * Insert order into orders table
     */
    public static void insertOrder(String description, int cost, String paymentType) {

        String sql = "INSERT INTO orders(description, cost, payment_type) VALUES(?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, description);
            pstmt.setInt(2, cost);
            pstmt.setString(3, paymentType);

            pstmt.executeUpdate();

            System.out.println("Order inserted into database successfully.");

        } catch (SQLException e) {
            System.out.println("Failed to insert order!");
            e.printStackTrace();
        }
    }
}

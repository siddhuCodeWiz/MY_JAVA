package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Shopping {
    private static final String URL = "jdbc:mysql://localhost:3306/shopping";
    private static final String USER = "root";
    private static final String PASSWORD = "VerBal#71";

    private static Connection connection;
    private static PreparedStatement checkStockStmt;
    private static PreparedStatement updateStockStmt;
    private static PreparedStatement insertOrderStmt;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);

            int userId = 1;
            int productId = 1;
            int orderQuantity = 2;

            // Check if there is enough stock
            checkStockStmt = connection.prepareStatement("SELECT stock FROM Products WHERE product_id = ?");
            checkStockStmt.setInt(1, productId);
            ResultSet rs = checkStockStmt.executeQuery();

            if (rs.next()) {
                int stock = rs.getInt("stock");
                if (stock >= orderQuantity) {
                    // Deduct stock
                    updateStockStmt = connection
                            .prepareStatement("UPDATE Products SET stock = stock - ? WHERE product_id = ?");
                    updateStockStmt.setInt(1, orderQuantity);
                    updateStockStmt.setInt(2, productId);
                    updateStockStmt.executeUpdate();

                    // Insert order record
                    insertOrderStmt = connection
                            .prepareStatement("INSERT INTO Orders (user_id, product_id, quantity) VALUES (?, ?, ?)");
                    insertOrderStmt.setInt(1, userId);
                    insertOrderStmt.setInt(2, productId);
                    insertOrderStmt.setInt(3, orderQuantity);
                    insertOrderStmt.executeUpdate();

                    System.out.println("Entered");

                    // Commit transaction
                    connection.commit();
                    System.out.println("Order placed successfully.");
                } else {
                    System.out.println("Insufficient stock for the order.");
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback transaction
                    System.out.println("Transaction failed. Rolled back.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (checkStockStmt != null) {
                try {
                    checkStockStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (updateStockStmt != null) {
                try {
                    updateStockStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (insertOrderStmt != null) {
                try {
                    insertOrderStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Practice {

    private static final String URL = "jdbc:mysql://localhost:3306/smartphones";
    private static final String USER = "root";
    private static final String PASSWORD = "VerBal#71";

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            statement = connection.createStatement();

            // Executing a simple SQL query
            // String query = "CREATE TABLE smarthphone_details (Smartphone varchar(50), Brand varchar(20), Model varchar(20), ram int, storage int, color varchar(20), free varchar(20), final_price float)";
            // statement.executeUpdate(query);
            // System.out.println("Created successfully");

            

            // Processing the result set
            // while (resultSet.next()) {
            //     System.out.println("Title: " + resultSet.getString("Name"));
            //     System.out.println("Genre: " + resultSet.getString("Rating"));
            //     // System.out.println("Release Year: " + resultSet.getInt("release_year"));
            //     // Add more columns as needed
            // }

            // Example of executing an update
            // String update = "UPDATE your_table SET column1 = ? WHERE column2 = ?";
            // preparedStatement = connection.prepareStatement(update);
            // preparedStatement.setString(1, "new_value");
            // preparedStatement.setString(2, "condition_value");
            // int rowsAffected = preparedStatement.executeUpdate();
            // System.out.println("Rows affected: " + rowsAffected);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Closing ResultSet, Statement, and Connection
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package Lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class _10a {
    private static final String URL = "jdbc:mysql://localhost:3306/employeedb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "VerBal#71";

    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            ps = con.prepareStatement("SELECT firstname FROM employees WHERE departmentid = ? ORDER BY firstname ASC");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter department Id: ");
            int id = sc.nextInt();
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("firstname"));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e);
            }
        }
    }
}

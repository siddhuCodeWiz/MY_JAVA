package JDBC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;



public class ReadCSV {
    private static final String URL = "jdbc:mysql://localhost:3306/smartphones";
    private static final String USER = "root";
    private static final String PASSWORD = "VerBal#71";

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    // static final int FETCH_UNKNOWN;

    public static void main(String[] args) {
        // String csvFile = "JDBC/smartphones.csv";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Prepare the SQL insert statement
            // String query = "INSERT INTO smarthphone_details (smartphone, brand, model, ram, storage, color, free, final_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            String query = "INSERT INTO customers (name, email, phone) VALUES('Alice Smith', 'alice.smith@example.com', '555-1234'),('Bob Johnson', 'bob.johnson@example.com', '555-5678'),('Charlie Brown', 'charlie.brown@example.com', '555-8765'),('Diana Prince', 'diana.prince@example.com', '555-4321'),('Edward Norton', 'edward.norton@example.com', '555-9876'),('Fiona Gallagher', 'fiona.gallagher@example.com', '555-1111'),('George Michael', 'george.michael@example.com', '555-2222'),('Hannah Baker', 'hannah.baker@example.com', '555-3333'),('Isaac Newton', 'isaac.newton@example.com', '555-4444'),('Jessica Jones', 'jessica.jones@example.com', '555-5555'),('Kevin Bacon', 'kevin.bacon@example.com', '555-6666'),('Lara Croft', 'lara.croft@example.com', '555-7777'),('Michael Scott', 'michael.scott@example.com', '555-8888'),('Nancy Drew', 'nancy.drew@example.com', '555-9999'),('Oscar Wilde', 'oscar.wilde@example.com', '555-0000'),('Pam Beesly', 'pam.beesly@example.com', '555-1010'),('Quentin Tarantino', 'quentin.tarantino@example.com', '555-2020'),('Rachel Green', 'rachel.green@example.com', '555-3030'),('Steve Rogers', 'steve.rogers@example.com', '555-4040'),('Tony Stark', 'tony.stark@example.com', '555-5050')";

            // Connection con;
            // preparedStatement = connection.prepareStatement(query);
            // preparedStatement.executeUpdate();
            Statement stmt = connection.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE,
                                      ResultSet.FETCH_UNKNOWN);
    

            String query1 = "select * from customers";
            ResultSet rs = stmt.executeQuery(query1);
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            // preparedStatement = connection.prepareStatement(query1);
            // resultSet = preparedStatement.executeQuery();
            // resultSet.FETCH_UNKNOWN;
            
            // ArrayList<ResultSet> res = new ArrayList<>();
            // while(resultSet.next()){
            //     System.out.print(resultSet.getString(1)+" ");
            //     System.out.print(resultSet.getString(2)+" ");
            //     System.out.print(resultSet.getString(3)+" ");
            //     System.out.println(resultSet.getString(4)+" ");
            // }

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter an option: ");
            String c = sc.nextLine();
            // sc.nextLine();

            while(true){
                switch (c) {
                    case "F":
                        rs.first();
                        System.out.print(rs.getString(1)+" ");
                        System.out.print(rs.getString(2)+" ");
                        System.out.print(rs.getString(3)+" ");
                        System.out.println(rs.getString(4)+" ");
                        break;

                    case "L":
                        rs.last();
                        System.out.print(rs.getString(1)+" ");
                        System.out.print(rs.getString(2)+" ");
                        System.out.print(rs.getString(3)+" ");
                        System.out.println(rs.getString(4)+" ");
                        break;

                    case "N":
                        rs.next();
                        System.out.print(rs.getString(1)+" ");
                        System.out.print(rs.getString(2)+" ");
                        System.out.print(rs.getString(3)+" ");
                        System.out.println(rs.getString(4)+" ");
                        break;

                    case "B":
                        System.out.println("THANK YOU");
                        break;

                    case "I":
                        rs.moveToInsertRow(); // moves cursor to the insert row
                        rs.updateString(2, "ABCD");
                        rs.updateString(3,"ABCDE@gmail.com");
                        rs.updateInt(4, 1234567895);
                        rs.insertRow();
                        rs.moveToCurrentRow();
                        System.out.println("SUCCESSFULLY INSERTED");
                        break;
                        
                    case "D":
                        System.out.println("Enter name to be deleted: ");
                        String na = sc.nextLine();
                        rs.first();
                        Boolean entered = false;
                        while(rs.next()){
                            if(rs.getString(2).equals(na)){
                                rs.deleteRow();
                                System.out.println("Deleted Successfully");
                                entered = true;
                            }
                        }
                        if(entered == false){
                            System.out.println("Name not found");
                        }
                        
                        break;

                    case "E":
                        break; 
                
                    default:
                        break;
                }
                System.out.print("Enter an option: ");
                c = sc.nextLine();
                // sc.nextLine();
            }
            // System.out.println(resultSet.findColumn("name"));





            // System.out.println(resultSet);

            // BufferedReader br = new BufferedReader(new FileReader(csvFile));
            // String line;
            // br.readLine(); // Skip header row

            // while ((line = br.readLine()) != null) {
            //     String[] data = line.split(",");

            //     String name = data[0];
            //     String brand = data[1];
            //     String model = data[2];
            //     int ram = data[3].isEmpty() ? 0:Integer.parseInt(data[3]);
            //     int storage = data[4].isEmpty()?0:Integer.parseInt(data[4]);
            //     String color = data[5];
            //     String free = data[6];
            //     float final_price = data[7].isEmpty()?0:Float.parseFloat(data[7]);

            //     preparedStatement.setString(1, name);
            //     preparedStatement.setString(2, brand);
            //     preparedStatement.setString(3, model);
            //     preparedStatement.setInt(4, ram);
            //     preparedStatement.setInt(5, storage);
            //     preparedStatement.setString(6, color);
            //     preparedStatement.setString(7, free);
            //     preparedStatement.setFloat(8, final_price);

            //     // Execute the prepared statement
            //     preparedStatement.executeUpdate();

            //     System.out.println("Added values: " + name + ", " + brand + ", " + model + ", " + ram + ", " + storage + ", " + color + ", " + free + ", " + final_price);
            // }

            // br.close();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        } finally {
            // Close the resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

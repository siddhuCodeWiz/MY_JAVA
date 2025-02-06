package Practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// import com.mysql.cj.jdbc.Driver;

public class LibraryManagement {

    private static String URL = "jdbc:mysql://localhost:3306/library";
    private static String username = "root";
    private static String password = "VerBal#71";

    private static Connection connection;
    // private static Statement statement;
    private static ResultSet rs;
    private static PreparedStatement addBook;
    private static PreparedStatement addMember;
    private static PreparedStatement issueBook;
    private static PreparedStatement returnBook;
    private static PreparedStatement viewBooks;
    private static PreparedStatement viewMembers;
    private static PreparedStatement viewIssued;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, username, password);

            // statement = connection.createStatement();

            addBook = connection.prepareStatement("INSERT INTO books (book_id, title, author, genre, quantity) values (?, ?, ?, ?, ?)");

            addMember = connection.prepareStatement("INSERT INTO members (member_id, name, email, phone_number) values (?, ?, ?, ?)");

            issueBook = connection.prepareStatement("INSERT INTO issuedBooks (book_id, member_id, issue_date)");

            returnBook = connection.prepareStatement("UPDATE issuedBooks SET return_date=? WHERE book_id=? AND member_id=?");

            viewBooks = connection.prepareStatement("SELECT * from books");

            viewMembers = connection.prepareStatement("SELECT * FROM members");

            viewIssued = connection.prepareStatement("SELECT * FROOM issuedbooks");


            boolean v = true;
            int op;

            System.out.println("\n1)Add book\n2)Add member\n3)Issue book\n4)Return book\n5)View books\n6)View members\n7)View issued books\n8)EXIT\nEnter an option:  ");
            Scanner sc = new Scanner(System.in);
            op = sc.nextInt();
            sc.nextLine();

            while(v){
                switch (op) {
                    case 1:
                        System.out.print("Enter book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter author: ");
                        String author = sc.nextLine();
                        System.out.print("Enter genre: ");
                        String genre = sc.nextLine();
                        System.out.print("Enter quantity: ");
                        int q = sc.nextInt();
                        sc.nextLine();

                        addBook.setInt(1, id);
                        addBook.setString(2, title);
                        addBook.setString(3, author);
                        addBook.setString(4, genre);
                        addBook.setInt(5, q);

                        try {
                            addBook.executeUpdate();
                            System.out.println("Successfully added book");
                        } catch (Exception e) {
                            System.out.println("Error in adding book: "+e);
                        }
                        break;

                    case 2:
                        System.out.print("Enter Member ID: ");
                        int memid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter email: ");
                        String  email= sc.nextLine();
                        System.out.print("Enter phone number: ");
                        String phone = sc.nextLine();
                        
                        addMember.setInt(1,memid);
                        addMember.setString(2, name);
                        addMember.setString(3, email);
                        addMember.setString(4, phone);

                        addMember.executeUpdate();
                        break;

                    case 3:
                        break;
                    case 4:
                        break;

                    case 5:
                        rs = viewBooks.executeQuery();
                        while(rs.next()){
                            System.out.println(rs.getString("title"));
                        }
                        
                    case 8:
                        v=false;
                        break;

                    default:
                        v=false;
                        break;
                }

                System.out.println("\n1)Add book\n2)Add member\n3)Issue book\n4)Return book\n5)View books\n6)View members\n7)View issued books\n8)EXIT\nEnter an option:  ");
                sc = new Scanner(System.in);
                op = sc.nextInt();
                sc.nextLine();
            }

        } catch (Exception e) {
            System.out.println("Eror in main: "+e);
        }
        
    }
    
}

// QUESTION 1:
// Develop an advanced inventory management system that reads product data from a CSV file and updates this data in two tables in the database: “products”and “product_inventory”. products( `product_id`, `name`, `category` ) and product_inventory(`product_id`, `quantity`, `warehouse_location`)
// The process involves the following steps:
// 1. Read product data from a CSV file.
// 2. Parse the data to extract relevant fields.
// 3. Validate the data to ensure no duplicate product IDs exist in the file and that all required fields are present. If duplicate product ID is found throw the DuplicateOrderId exception and continue with the next row in csv file. 
// 4. Insert or update the product data into the `products` table.
// 5. Insert or update the inventory data into the `product_inventory` table.
// These steps must be performed within a single transaction to ensure data consistency. If any step fails, the transaction should be rolled back entirely to maintain data integrity.
// Instructions:
// 1. Implement the method `processProductData` in the `InventoryService` class to handle the file I/O and database operations properly.
// 2. Ensure that if reading from the file, validating the data, or updating the database fails, the transaction is rolled back and an appropriate error message is logged.
// 3. Use a transaction to ensure that updates to both tables are atomic.
// 4. Make sure to manage resources appropriately, closing file readers and database connections as needed.
// Scenario Details
// products.csv
// 101,Widget A,Electronics,50,Warehouse 1
// 102,Gadget B,Home,30,Warehouse 2
// 103,Tool C,Hardware,20,Warehouse 3
// 104,Device D,Electronics,40,Warehouse 1
// 105,Appliance E,Home,25,Warehouse 2
// 102,Gadget B,Home,30,Warehouse 2
// 102,Gadget B,Home,30,Warehouse 2
// 107,Instrument F,Medical,15,Warehouse 4
// 107,Apparatus G,Industrial,35,Warehouse 5
// 108,Implement H,Agriculture,10,Warehouse 6
// 109,Equipment I,Sports,22,Warehouse 7
// 110,Machine J,Automotive,27,Warehouse 8  

// Ensure that the database operations are performed within a transaction, rolling back if any operation fails.
// Make sure to close all file readers, writers, and database connections in a `finally` block or use try-with-resources to ensure they are closed even if an exception occurs.

// -----------------------------------

// QUESTION 2:
// Developing a library management system that processes book records. Your task involves reading book data from a CSV file, sorting the books by their publication year and their ISBN number, and then serializing the sorted book objects to its respective binary files for efficient storage and retrieval. The process involves the following steps:
// 1. Read book data from a CSV file.
// 2. Parse the data to create `Book` objects.
// 3. Sort the `Book` objects based on their publication year using a custom `Comparator`.
// 4. Serialize the sorted `Book` objects to a binary file.
// Repeat steps 3, 4 for ISBN comparator
// 1. Implement the method `processBookData` in the `LibraryService` class to handle the file I/O, sorting, and serialization operations.
// 3. Ensure that the book data is read from the CSV file and `Book` objects are created properly.
// 4. Sort the `Book` objects based on their publication year in ascending order using a custom `Comparator`.
// 5. Serialize the sorted list of `Book` objects to a binary file named `"sorted_books_yearwise.dat"`.
// Repeat 4, 5 for another comparator.
// 6. Handle all exceptions appropriately and ensure that resources are closed properly.
// 7. Display all the sorted Books both yearwise and ISBN wise before serializing it.
// Scenario Details:
// - Source file path: `"books.csv"`
// - Binary output file path: `"sorted_books_yearwise.dat"`
// - Binary output file path: `"sorted_books_ISBN.dat"`
// - `Book` class fields: `isbn`, `title`, `author`, `publicationYear`

// Example Data:
// - CSV file content (`books.csv`):

//   978-0134685991,Effective Java,Joshua Bloch,2018
//   978-0596009205,Head First Java,Kathy Sierra,2005
//   978-0132350884,Clean Code,2008
//   978-0134685991,Java Concurrency in Practice,Brian Goetz,2006
//   978-0134494166,Effective Java 2nd Edition,Joshua Bloch,2008
//   978-0201633610,Design Patterns,Erich Gamma
//   978-0321356680,Introduction to Algorithms,Thomas H. Cormen,2009
//   978-0132350884,Refactoring,Martin Fowler,1999
//   978-0132350884,Domain-Driven Design,Eric Evans,2003
//   978-0321356680,The Pragmatic Programmer,Andrew Hunt,1999
// ****Note: There would be certain row where some information would be missing, in that case you need to throw an error InsuffiencientInformation while processing that row and continue with the work. That row should not be included in the sorting order.  

// -----------------------------------------------

// QUESTION 3:
// Develop a multithreaded Quiz application where BOT would ask the question and multiple users can answer concurrently. The chat system should handle synchronization properly to avoid race conditions and ensure message integrity. 
// The output should appear in the following order : 
// BOT asks: What is the capital of India?
// User1: Delhi
// User2: Bombay
// User3: New Delhi
// BOT asks: What is the largest planet in our solar system?
// User1: Jupiter
// User2: Saturn
// User3: Earth
// ………. Etc. 
// Make sure after every user answers then only the BOT can ask the next question.
// --------------------------------------------------------------------------------------------------------------------- QUESTION 4:

// QUESTION 4:
// Develop a multithreaded application where one thread writes data to a file, and two other threads read the data and sort it using different comparators concurrently. The application involves the following tasks:
// 1.	A thread that writes a series of employee records to a file.
// 2.	A thread that reads the employee records from the file and sorts them by name and print it.
// 3.	A thread that reads the employee records from the file and sorts them by salary and print it.
// A thread can’t read and sort until the records are not written, this multithreaded application should handle synchronization and ensure that each task is performed correctly and concurrently.

// -----------------------------------------

// QUESTION 5:
// Managing a scholarship system for a university. The system maintains records of students, scholarships, and the scholarships awarded to students. Managing Transactions with Savepoints and Rollbacks
// The database has the following structure:
//  Database Tables
// *Students* table:
//    - StudentID (INT, Primary Key)
//    - StudentName (VARCHAR)
//    - TotalCredits (INT)
// *Scholarships* table:
//    - ScholarshipID (INT, Primary Key)
//    - ScholarshipName (VARCHAR)
//    - Amount (DECIMAL)
// *Awards* table:
//    - AwardID (INT, Primary Key)
//    - StudentID (INT, Foreign Key referencing Students.StudentID)
//    - ScholarshipID (INT, Foreign Key referencing Scholarships.ScholarshipID)
//    - AwardDate (DATE)
// Create a Java program that performs the following operations within a transaction:
// 1. Register a student for a scholarship by inserting a new record into the Awards table.
// 2. Deduct the scholarship amount from the student's total credits.
// 3. Add the scholarship amount to the student's account (assuming another table Accounts for simplicity).
// 4. If any operation fails, roll back to the previous state using a savepoint.
// 5. Ensure that if a student's total credits become negative, the transaction should be completely rolled back.
// Task 1: Create and Populate Database
// Step 1: Write the SQL statements to create the above tables.
// Step 2: Populate the tables with the following sample data:

// *Students Table:*
// csv
// StudentID,StudentName,TotalCredits
// 1,John Doe,30
// 2,Jane Smith,45
// 3,Emily Johnson,60
// 4,Michael Brown,25
// 5,Jessica White,40


// *Scholarships Table:*
// csv
// ScholarshipID,ScholarshipName,Amount
// 1,Academic Excellence,1000.00
// 2,Community Service,500.00
// 3,Sports Achievement,750.00
// 4,Arts and Culture,300.00
// 5,Research Grant,1200.00
// *Awards Table:*
// csv
// AwardID,StudentID,ScholarshipID,AwardDate
// 1,1,1,2024-01-15
// 2,2,2,2024-02-20
// 3,3,3,2024-03-25
// 4,4,4,2024-04-10
// 5,5,5,2024-05-05

// Task 2: Java Program for Managing Transactions
// Create a Java program using JDBC that performs the following operations:
// 1. Insert a new award record for a student (StudentID = 2) receiving a scholarship (ScholarshipID = 1) on 2024-07-20.
// 2. Deduct the scholarship amount from the student's total credits.
// 3. Add the scholarship amount to the student's account in the Accounts table (assume Accounts table has columns StudentID and Balance).
// 4. Use a savepoint before updating the student's total credits.
// 5. Roll back to the savepoint if the total credits become negative.
// 6. Roll back the entire transaction if any operation fails.















package Mine.Threading;

class Chat1 {
    boolean flag;
    int count;
    int ca;

    Chat1(){
       flag = false;
       count = 0;
       ca=0;
    }

    public synchronized void question(String s) {
        if (flag) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
        if(!flag){
            System.out.print("Bot asks: ");
            System.out.println(s);
            flag = true;
            count++;
            notifyAll();
        }
    }

    public synchronized void answer(String[] s) {
        if (!flag) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
        if(flag){
            System.out.print("User 1: ");
            System.out.println(s[ca]);
            ca++; System.out.print("User 2: "); System.out.println(s[ca]);
            ca++; System.out.print("User 3: "); System.out.println(s[ca]);
            ca++;
            flag = false;
            notify();
        }
        
    }
}

class QuestionRunnable implements Runnable{
    Chat1 m;
    String q[] = {"What is the capital of India?", "What is the largest planet in our solar system?", "How are you"};
    int c;

    QuestionRunnable(Chat1 m){
        this.m = m;
    }
    @Override
    public void run() {
        for(int i=0; i<3; i++){
            m.question(q[i]);
        }
    }
}

class AnswerRunnable implements Runnable{
    Chat1 m;
    String a[] = {"Delhi", "Bombay", "New Delhi", "Jupiter", "Saturn", "Earth", "Fine", "Good", "Doing well"};
    int c;
    AnswerRunnable(Chat1 m){
        this.m = m;
        c=0;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            m.answer(a);
        }
    }
}

public class Quiz {
    public static void main(String[] args) {
        Chat1 m = new Chat1();
        QuestionRunnable q1 = new QuestionRunnable(m);
        AnswerRunnable a1 = new AnswerRunnable(m);

        Thread t1 = new Thread(q1);
        Thread t2 = new Thread(a1);

        t1.start();
        t2.start();
    }
}

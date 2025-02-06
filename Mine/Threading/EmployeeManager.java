package Mine.Threading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// class Employee {
//     int id;
//     String name;
//     int age;
//     String department;

//     Employee(int id, String name, int age, String department) {
//         this.id = id;
//         this.name = name;
//         this.age = age;
//         this.department = department;
//     }

//     @Override
//     public String toString() {
//         return "Employee{" +
//                 "id=" + id +
//                 ", name='" + name + '\'' +
//                 ", age=" + age +
//                 ", department='" + department + '\'' +
//                 '}';
//     }
// }

// class EmployeeWriter implements Runnable {
//     private final List<Employee> employeeList;
//     private final String csvFile;

//     EmployeeWriter(List<Employee> employeeList, String csvFile) {
//         this.employeeList = employeeList;
//         this.csvFile = csvFile;
//     }

//     @Override
//     public void run() {
//         try (BufferedReader br = new BufferedReader(new FileReader("employee.csv"))) {
//             String line;
//             br.readLine(); // Skip header
//             while ((line = br.readLine()) != null) {
//                 String[] data = line.split(",");
//                 Employee employee = new Employee(
//                         Integer.parseInt(data[0]),
//                         data[1],
//                         Integer.parseInt(data[2]),
//                         data[3]
//                 );
//                 synchronized (employeeList) {
//                     employeeList.add(employee);
//                 }
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }

// class EmployeeSorterByName implements Runnable {
//     private final List<Employee> employeeList;

//     EmployeeSorterByName(List<Employee> employeeList) {
//         this.employeeList = employeeList;
//     }

//     @Override
//     public void run() {
//         synchronized (employeeList) {
//             try {
//                 employeeList.wait(); // Wait for the writer to finish
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//             Collections.sort(employeeList, Comparator.comparing(employee -> employee.name));
//             System.out.println("Employees sorted by name:");
//             for (Employee employee : employeeList) {
//                 System.out.println(employee);
//             }
//         }
//     }
// }

// class EmployeeSorterByAge implements Runnable {
//     private final List<Employee> employeeList;

//     EmployeeSorterByAge(List<Employee> employeeList) {
//         this.employeeList = employeeList;
//     }

//     @Override
//     public void run() {
//         synchronized (employeeList) {
//             try {
//                 employeeList.wait(); // Wait for the writer to finish
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//             Collections.sort(employeeList, Comparator.comparingInt(employee -> employee.age));
//             System.out.println("Employees sorted by age:");
//             for (Employee employee : employeeList) {
//                 System.out.println(employee);
//             }
//         }
//     }
// }

// public class EmployeeManager {
//     public static void main(String[] args) {
//         List<Employee> employeeList = new ArrayList<>();
//         String csvFile = "employee.csv";

//         Thread writerThread = new Thread(new EmployeeWriter(employeeList, csvFile));
//         Thread sorterByNameThread = new Thread(new EmployeeSorterByName(employeeList));
//         Thread sorterByAgeThread = new Thread(new EmployeeSorterByAge(employeeList));

//         writerThread.start();
//         sorterByNameThread.start();
//         sorterByAgeThread.start();

//         try {
//             writerThread.join();
//             synchronized (employeeList) {
//                 employeeList.notifyAll(); // Notify sorters that writing is done
//             }
//             sorterByNameThread.join();
//             sorterByAgeThread.join();
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }
// }

class Employee {
    int id;
    String name;
    int age;
    String department;

    Employee(int id, String name, int age, String department) {
        // this.id = id;
        // this.name = name;
        // this.age = age;
        // this.department = department;
    }
}

class AddEmployee extends Employee {

    static ArrayList<Employee> emp;

    {
        emp = new ArrayList<>();
    }

    AddEmployee(int id, String name, int age, String department) {
        super(id, name, age, department);
        emp.add(new Employee(id, name, age, department));
    }

    void addEmployee(Employee e) {
        emp.add(e);
    }

    ArrayList<Employee> getEmployeeList() {
        return emp;
    }
}

class SortByAge implements Runnable {
    @Override
    public void run() {

    }
}

class WriteToFile implements Runnable {
    @Override
    public void run() {
        try {
            FileWriter writer = new FileWriter("Mine/Threading/employee.csv");
            writer.write("ID, Name, Age, Department\n");
            writer.append(
                    "1,John Doe,30,Engineering\n2,Jane Smith,25,Marketing\n3,Sam Brown,35,Sales\n4,Anna White,28,Engineering\n5,Tom Black,40,HR");
            writer.close();

            System.out.println("Successfully inserted the data.");

        } catch (Exception e) {
            System.out.println("Error while writing to file: " + e);
        }
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        WriteToFile t1 = new WriteToFile();
        Thread tt1 = new Thread(t1);
        tt1.start();
    }
}
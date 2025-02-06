package EmployeeSorter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class SortByAge implements Runnable {
    @Override
    public void run() {
        ArrayList<Employee> e = AddEmployee.getEmployeeList();
        System.out.println("Enebfj");
        for(Employee em:e){
            System.out.println(em.name);
        }
        Collections.sort(e, Comparator.comparingInt(employee -> employee.age));

        try (FileWriter f = new FileWriter("EmployeeSorter/employee.csv", true)) {
            StringBuilder s = new StringBuilder();
            for (Employee em : e) {
                s.append(em.id).append(" ").append(em.name).append(" ").append(em.age).append(" ").append(em.department).append("\n");
            }
            f.append("\nAfter Sorting with age:\n").append(s);
        } catch (Exception ex) {
            System.out.println("Error while sorting: " + ex);
        }
    }
}


class SortByDepartment implements Runnable {
    @Override
    public void run() {
        ArrayList<Employee> e = AddEmployee.getEmployeeList();
        System.out.println("Enebfj");
        for(Employee em:e){
            System.out.println(em.name);
        }
        Collections.sort(e, Comparator.comparing(employee -> employee.department));

        try (FileWriter f = new FileWriter("EmployeeSorter/employee.csv", true)) {
            StringBuilder s = new StringBuilder();
            for (Employee em : e) {
                s.append(em.id).append(" ").append(em.name).append(" ").append(em.age).append(" ").append(em.department).append("\n");
            }
            f.append("\nAfter Sorting with department:\n").append(s);
        } catch (Exception ex) {
            System.out.println("Error while sorting: " + ex);
        }
    }
}

class WriteToFile implements Runnable {
    @Override
    public void run() {
        try {
            FileWriter writer = new FileWriter("EmployeeSorter/employee.csv");
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


class ReadEmployees implements Runnable {
    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("EmployeeSorter/employee.csv"));
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length == 4) {
                    int id = Integer.parseInt(values[0].trim());
                    String name = values[1].trim();
                    int age = Integer.parseInt(values[2].trim());
                    String department = values[3].trim();

                    Employee e1 = new Employee(id, name, age, department);
                    AddEmployee.addEmployee(e1);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error while reading employees: " + e);
        }
    }
}


public class EmployeeManager {
    public static void main(String[] args) {
        WriteToFile t1 = new WriteToFile();
        SortByAge t2 = new SortByAge();
        ReadEmployees t3 = new ReadEmployees();
        Thread tt1 = new Thread(t1);
        Thread tt2 = new Thread(t2);
        Thread tt3 = new Thread(t3);

        try {
            tt1.start();
            tt1.join();
            tt3.start();
            tt3.join();
            tt2.start();
            tt2.join(); // Ensure t2 completes before continuing
        } catch (Exception e) {
            System.out.println("Exception in main thread: " + e);
        }
    }
}

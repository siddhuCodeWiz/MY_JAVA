package EmployeeSorter;

import java.util.ArrayList;

class AddEmployee{

    static ArrayList<Employee> emp;

    AddEmployee() {
        emp = new ArrayList<>();
        // emp.add(new Employee(id, name, age, department));
    }

    // static void addEmp(int id, String name, int age, String department){
    //     emp.add(new Employee(id, name, age, department));
    // }

    static void addEmployee(Employee e) {
        try {
            emp.add(e);
        } catch (Exception ex) {
            System.out.println("Error while reading record: "+ ex);
        }
        
    }

    static ArrayList<Employee> getEmployeeList() {
        return emp;
    }
}

package ConstructionCompany;

public class Employee {
    private int empId;
    private String name;
    private double salary;

    Employee(int empId, String name, double salary){
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary(){
        return this.salary;
    }

    public void setSalary(double s){
        this.salary = s;
        System.out.println(this.name+"'s salary has been set to "+this.salary);
    }

    public int getEmpId(){
        return this.empId;
    }

    public void setEmpId(int s){
        this.empId = s;
        System.out.println(this.name+"'s employee ID has been set to "+this.empId);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String s){
        this.name = s;
        System.out.println("Employee with ID number "+this.empId+" has been assigned with the name "+this.name);
    }
}

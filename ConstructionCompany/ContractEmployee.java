package ConstructionCompany;

public class ContractEmployee extends Employee{
    private double wages;
    private int hours;

    ContractEmployee(int empId, String name, double wages, int hours){
        super(empId, name, 0);
        this.wages = wages;
        this.hours = hours;
        this.calculateSalary();
    }

    public double getWages(){
        return this.wages;
    }

    public void setWages(double s){
        this.wages = s;
        System.out.println(super.getName()+"'s wage has been set to "+this.wages);
    }

    public int getHours(){
        return this.hours;
    }

    public void setEmpId(int s){
        this.hours = s;
        System.out.println(super.getName()+"'s hours has been set to "+this.hours);
    }

    public void calculateSalary(){
        double sal = (this.hours)*(this.wages);
        super.setSalary(sal);

        System.out.println(super.getName()+"'s Salary is "+super.getSalary());
    }
}

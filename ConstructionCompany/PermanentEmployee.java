package ConstructionCompany;

public class PermanentEmployee extends Employee {
    private double basicPay;
    private double hra;
    private int experience;

    PermanentEmployee(int empId, String name, double basicPay, double hra, int experience){
        super(empId, name, 0);
        this.basicPay = basicPay;
        this.hra = hra;
        this.experience = experience;
        this.calculateSalary();
    }

    public double getBasicPay(){
        return this.basicPay;
    }

    public void setBasicPay(double s){
        this.basicPay = s;
        System.out.println(super.getName()+"'s basic pay has been set to "+this.basicPay);
    }

    public double getHra(){
        return this.hra;
    }

    public void setEmpId(double s){
        this.hra = s;
        System.out.println(super.getName()+"'s HRA has been set to "+this.hra);
    }

    public int getExperince(){
        return this.experience;
    }

    public void setExperience(int s){
        this.experience = s;
        System.out.println(super.getName()+"'s experience has been set to "+this.experience);
    }

    public void calculateSalary(){
        double vc;
        
        if(this.experience < 3){
            vc = 0;
        } else if(this.experience>=3 && this.experience<5){
            vc = (0.05)*(this.basicPay);
        } else if(this.experience>=5 && this.experience<10){
            vc = (0.07)*(this.basicPay);
        } else if(this.experience>=10){
            vc = (0.12)*(this.basicPay);
        } else{
            vc=0;
        }

        double sal = (vc)+(this.basicPay)+(this.hra);
        super.setSalary(sal);

        System.out.println(super.getName()+"'s Salary is "+super.getSalary());
    }
}

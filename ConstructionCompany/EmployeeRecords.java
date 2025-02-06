package ConstructionCompany;
import java.util.*;

public class EmployeeRecords {
    public static void main(String[] args){
        PermanentEmployee e1;

        ContractEmployee e2;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter records of:\n1. Permanent Employee\n2. Contract Employee\nEnter option: ");
        int op = sc.nextInt();
        sc.nextLine();

        if(op==1){
            System.out.print("Enter employee name: ");
            String n = sc.nextLine();

            System.out.print("Enter employee ID: ");
            int eid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter employee Basic Pay: ");
            double bp = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter employee HRA: ");
            double hra = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter employee experience: ");
            int ex = sc.nextInt();
            sc.nextLine();

            e1 = new PermanentEmployee(eid, n, bp, hra, ex);
        } else if(op==2){
            System.out.print("Enter employee name: ");
            String n = sc.nextLine();

            System.out.print("Enter employee ID: ");
            int eid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter employee Wage: ");
            double wage = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter employee working hours: ");
            int hr = sc.nextInt();
            sc.nextLine();

            e2 = new ContractEmployee(eid, n, wage, hr);
        }
        sc.close();
    }
}

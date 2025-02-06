package Exceptions;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;



public class Employee {

    public static class DepartmentException extends Exception {
        String name;
        DepartmentException(String name){
            this.name = name;
        }
        @Override
        public String getMessage() {
            // TODO Auto-generated method stub
            // return super.getMessage();
            return name+" is from invalid department";
        }
        
    }

    public static class SalaryException extends Exception {
        String name;
        SalaryException(String name){
            this.name = name;
        }
        @Override
        public String getMessage() {
            // TODO Auto-generated method stub
            // return super.getMessage();
            return name+" salary is less than 10000";
        }  
    }

    public static class AgeException extends Exception {
        String name;
        AgeException(String name){
            this.name = name;
        }
        @Override
        public String getMessage() {
            // TODO Auto-generated method stub
            // return super.getMessage();
            return name+" age is greater than 65";
        }  
    }

    public static void main(String[] args) throws IOException{
        File f = new File("Exceptions/employee.txt");
        Scanner sc = new Scanner(f);
        String[] a;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            // System.out.println(line);
            String s = "";
            
            // for(int i=0; i<line.length(); i++){
            //     if(line.charAt(i)==','){
            //         s="";
            //     }
            //     else{
                    
            //     }
            // }
            a = line.split(",", 4);
            // for(int i=0; i<a.length; i++){
            //     System.out.print(a[i]+" ");
            // }
            // System.out.println();
            try{
                if(a[2].equals("WaterDept") || a[2].equals("Accounts")){
                    // continue;
                } else{
                    throw new DepartmentException(a[0]);
                }
            }
            catch(DepartmentException e){
                System.out.println(e.getMessage());
            }
            
            try {
                if(Integer.parseInt(a[3]) < 5000){
                    throw new SalaryException(a[0]);
                }
            } catch (SalaryException e) {
                System.out.println(e.getMessage());
            }

            try {
                if(Integer.parseInt(a[1]) > 65){
                    throw new AgeException(a[0]);
                }
            }
            catch (AgeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
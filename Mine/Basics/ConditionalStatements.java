package Mine.Basics;

import java.util.*;

class ScannerLearning{
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your favorite food: ");
        String food = sc.nextLine();
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Food: "+food);
    }
};

public class ConditionalStatements {

    public static int factorial(int n){
        int res=1;
        for(int i=1; i<=n; i++){
            res*=i;
        }

        return res;
    }
    public static void main(String[] args) {
        // System.out.println("Enter your age: ");
        // Scanner sc = new Scanner(System.in);
        // int age = sc.nextInt();

        // if(age<18){
        //     System.out.println("You are a minor");
        // }
        // else if(age==18){
        //     System.out.println("You are eighteen");
        // }
        // else{
        //     System.out.println("You are a major");
        // }



        // for(int i=0; i<10; i++){
        //     System.out.printf("%d ",i);
        // }

        // System.out.print("\n");

        // int f = sc.nextInt();
        // int fact = factorial(f);

        // System.err.printf("Factorial of %d is %d",f,fact);

        ScannerLearning s = new ScannerLearning();
        s.run();
    }
}

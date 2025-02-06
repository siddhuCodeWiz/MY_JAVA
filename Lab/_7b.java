package Lab;
import java.util.*;

public class _7b {
    static class A extends Thread{
        @Override
        public void run() {
            System.out.println("FizzBuzz");
        }
    }

    static class B extends Thread{
        @Override
        public void run() {
            System.out.println("Fizz");
        }
    }

    static class C extends Thread{
        @Override
        public void run() {
            System.out.println("Buzz");
       }
    }

    static class D extends Thread{
        int i;
        D(int i){
            this.i = i;
        }
        @Override
        public void run() {
            System.out.println(i);
        }
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");

        int n = sc.nextInt();

        try {
            for(int i=1; i<=n; i++){
                if(i%3==0 && i%5==0){
                    A a = new A();
                    a.start();
                    a.join();
                }
                else if(i%5==0){
                    B b = new B();
                    b.start();
                    b.join();
                }
                else if(i%3==0){
                    C c = new C();
                    c.start();
                    c.join();
                }
                else{
                    D d = new D(i);
                    d.start();
                    d.join();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: "+e);
        }

        
    }
}

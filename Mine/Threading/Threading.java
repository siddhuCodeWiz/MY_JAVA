package Mine.Threading;

class Thread1 extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("Thread 1 is running");
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("Thread 2 is running");
        }
    }
}

class ThreadRunnable3 implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("Thread 3 is running");
        }
    }
};





class BaseClass {
    public void baseMethod() {
        System.out.println("BaseClass method called");
    }
}


class MyRunnableClass extends BaseClass implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Thread is running");
            baseMethod();  // Call a method from the superclass
            try {
                Thread.sleep(1000);  // Sleep for a second
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;  // Exit the loop if interrupted
            }
        }
    }
}


public class Threading {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        // t1.start();
        // t2.start();

        // ThreadRunnable3 tr3 = new ThreadRunnable3();
        // Thread t3 = new Thread(tr3);

        // t3.start();
        


        MyRunnableClass myRunnable = new MyRunnableClass();
        
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}

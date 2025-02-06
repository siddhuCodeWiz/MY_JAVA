package Mine.Threading;

class Counter implements Runnable{
    @Override
    public void run(){
        while(true){
            System.out.println("Runnable");
        }
    }
}

class Task1 implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<200; i++){
            System.out.println(i+" "+Thread.currentThread().getName());
        }
        
    }

}

class Task2 implements Runnable{
    @Override
    public void run() {
        for(int i=500; i<1000; i++){
            System.out.println(i+" "+Thread.currentThread().getName());
        }
        
    }
}

class Task3 implements Runnable{
    @Override
    public void run() {
        for(int i=1000; i<1200; i++){
            System.out.println(i+" "+Thread.currentThread().getName());
        }
    }
}

public class TestThread {
    public static void main(String[] args) {
        // Counter c = new Counter();

        // Thread t = new Thread(c);
        // t.start();

        Task1 tt1 = new Task1();
        Task2 tt2 = new Task2();
        Task3 tt3 = new Task3();

        Thread t1 = new Thread(tt1, "Thread1");
        Thread t2 = new Thread(tt2, "Thread2");
        Thread t3 = new Thread(tt3, "Thread3");
        t1.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();


        // while(true){
        //     System.out.println("Main thread: ");
        // }

        // Main thread will go to dead state after it has completed its execution
        // But the thread which we have created will be still running   

        System.out.println("Main method is exiting...");

    }
}

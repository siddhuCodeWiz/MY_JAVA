package Mine.Threading;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class ThreadsBasics {
    public static void main(String[] args) {
        SimpleRunnable r = new SimpleRunnable();
        Thread t1 = new Thread(r);
        t1.setDaemon(true);
        t1.setName("Simple");
        t1.start(); 

        // Thread t = Thread.ofPlatform().name("Simple").daemon(true).start(r);

        System.out.println("Main thread finished");
    }
}

class SimpleRunnable implements Runnable{
    @Override
    public void run(){
        try{
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Hello there");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
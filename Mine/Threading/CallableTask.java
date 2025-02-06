package Mine.Threading;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableTask {

    public static TaskResult doSimpleTask(String name, int secs, boolean fail){
        System.out.println(Thread.currentThread().getName()+": Starting task: "+ name);
        try {
            TimeUnit.SECONDS.sleep(secs);
        } catch (Exception e) {
            System.out.println("Task interupted");
        }

        if(fail){
            throw new RuntimeException("Task Failed");
        }

        System.out.println(Thread.currentThread().getName()+": Ending task: "+name);
        return new TaskResult(name, secs);
    }

    public static void main(String[] args) {

        try {
            
            // // Submitting multiple callable tasks
            // ExecutorService service = Executors.newFixedThreadPool(3);
            // Future<TaskResult> task1future = service.submit(()->doSimpleTask("First", 3, false));
            // Future<TaskResult> task2future = service.submit(()->doSimpleTask("Second", 2, false));
            // Future<TaskResult> task3future = service.submit(()->doSimpleTask("Third", 1, false));
            // try {
            //     TaskResult tr1 = task1future.get();  //Even if the tr3 is completed we will wait till the tr1 is completed
            //     System.out.println(tr1);
            //     TaskResult tr2 = task2future.get();
            //     System.out.println(tr2);
            //     TaskResult tr3 = task3future.get();
            //     System.out.println(tr3);
            // } catch (Exception e) {
            //     System.out.println(e);
            // }
            // service.shutdown();



            // ExecutorCompletionService
            ExecutorService service = Executors.newFixedThreadPool(3);
            ExecutorCompletionService srv = new ExecutorCompletionService<>(service);
            Callable<TaskResult> callable1 = ()-> doSimpleTask("First", 3, false);
            Callable<TaskResult> callable2 = ()-> doSimpleTask("Second", 1, false);
            Future<TaskResult> task1future = srv.submit(callable1);
            Future<TaskResult> task2future = srv.submit(callable2);
            try {
                Future future = srv.take();
                if(future == task1future){
                    System.out.println(future.get());
                }
                if(future == task2future){
                    System.out.println(future.get());
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            service.shutdown();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}


class TaskResult{
    String name;
    long secs;
    TaskResult(String name, long secs){
        this.name = name;
        this.secs = secs;
    }

    @Override
    public String toString(){
        return name+" "+secs;
    }
}




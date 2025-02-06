package Mine.Threading;

class Chat {
    boolean flag;
    int count;

    Chat(){
       flag = false;
       count = 0;
    }

    public synchronized void question(String s) {
        if (count>0) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
        if(count==0){
            System.out.println(s);
            flag = true;
            count++;
            notifyAll();
        }
    }

    public synchronized void answer(String s) {
        if (count==0) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
        // if(count>3){
        //     count=0;
        //     notify();
        // }
        // if(count>0 && count<=3){
            System.out.println(s);
            flag = false;
            count++;
            if(count>4){
                count=0;
                notify();
            }
        // }
        
    }
}

class QRunnable implements Runnable {
    Chat m;
    String[] a = { "Broadcast1", "Broadcast2", "Broadcast3"};

    QRunnable(Chat m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            m.question(a[i]);
        }
    }
}

class ARunnable implements Runnable {
    Chat m;
    String[] a = { "Answer1", "Answer2", "Answer3" };

    ARunnable(Chat m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            m.answer(a[i]);
        }
    }
}

public class QandA {
    public static void main(String[] args) {
        Chat m = new Chat();
        QRunnable q = new QRunnable(m);
        ARunnable a = new ARunnable(m);
        Thread t1 = new Thread(q);
        Thread t2 = new Thread(a);

        t1.start();
        t2.start();
    }
}

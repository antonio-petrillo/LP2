import java.util.concurrent.*;

public class QueueOfTasks {

    private BlockingQueue<Runnable> q;
    private Thread consumer;

    public QueueOfTasks() {
        q = new LinkedBlockingQueue<>();
        consumer = new Thread(() -> {
            Runnable r;
            while (true) {
                try {
                    r = q.take();
                    r.run();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        });
        consumer.start();
    }

    public void add(Runnable r) {
        try {
            q.put(r);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) {
        QueueOfTasks q = new QueueOfTasks();
        Runnable r1 = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    return;
                }
                System.out.println("Io adoro i thread!");
            }
        };
        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("Io odio i thread!");
            }
        };
        q.add(r1);
        q.add(r1);
        q.add(r2);
        System.out.println("fatto .");
    }

}

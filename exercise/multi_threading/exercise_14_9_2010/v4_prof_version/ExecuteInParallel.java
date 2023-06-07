import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ExecuteInParallel {

    // Crea comunque molti thread?
    public static void executeInParallel(Runnable[] runnables, int k) throws InterruptedException {
        BlockingQueue<Thread> q = new ArrayBlockingQueue<>(k);
        for (var r : runnables) {
            Thread t = new Thread(() -> {
                r.run();
                q.remove(t);
            });
            q.put(t);
            t.start();
        }
    }

}

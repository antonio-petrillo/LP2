import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.function.*;

public class ExecuteInParallel {

    public static void main(String[] args) {
        runWithNRunnablesAndKConsumer(100, 2);
    }

    public static void executeInParallel(Runnable[] runnables, int k) {
        Thread[] consumers = new Thread[k];
        BlockingQueue<Runnable> q = new ArrayBlockingQueue<>(k);
        Thread producer = Thread.currentThread();
        IntStream
                .range(0, k)
                .forEach(i -> {
                    consumers[i] = new Thread(() -> {
                        while (producer.isAlive() || !q.isEmpty()) {
                            try {
                                q.take().run();
                            } catch (InterruptedException ie) {
                                ie.printStackTrace();
                                return;
                            }
                        }
                    });
                    consumers[i].setDaemon(true);
                    consumers[i].start();
                });
        for (var r : runnables) {
            try {
                q.put(r);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return;
            }
        }
    }

    public static void runWithNRunnablesAndKConsumer(int n, int k) {
        Supplier<Runnable> supplier = () -> () -> System.out
                .println("Here is a job for " + Thread.currentThread().getName());
        Runnable[] runnables = Stream
                .generate(supplier)
                .limit(n)
                .toArray(Runnable[]::new);
        long start = System.currentTimeMillis();
        executeInParallel(runnables, k);
        long end = System.currentTimeMillis();
        System.out.printf("With [%d, %d] the execution takes %d millisecond.\n", n, k, (end - start));
    }

}

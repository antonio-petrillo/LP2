import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class ExecuteInParallel {

    public static void main(String[] args) {
        runWithNRunnablesAndKConsumer(100, 2);
        runWithNRunnablesAndKConsumer(1000, 10);
        runWithNRunnablesAndKConsumer(100000, 25);
        runWithNRunnablesAndKConsumer(1000000, 25);
        runWithNRunnablesAndKConsumer(10000000, 100);
    }

    public static void executeInParallel(Runnable[] runnables, int k) {
        AtomicInteger index = new AtomicInteger();
        BlockingQueue<Runnable> q = new LinkedBlockingQueue<>();
        Thread masterProducer = new Thread(() -> {
            Thread[] producers = new Thread[k];
            for (int i = 0; i < k; i++) {
                producers[i] = new Thread(() -> {
                    while (true) {
                        int localIndex = index.getAndIncrement();
                        if (localIndex >= runnables.length)
                            break;
                        try {
                            q.put(runnables[localIndex]);
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                            return;
                        }
                    }
                });
                producers[i].start();
            }
            for (int i = 0; i < k; i++) {
                try {
                    producers[i].join();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                    return;
                }
            }
        });
        masterProducer.start();
        Thread[] consumers = new Thread[k];
        for (int i = 0; i < k; i++) {
            consumers[i] = new Thread(() -> {
                if (masterProducer.isAlive() || !q.isEmpty()) {
                    System.out.println("Producers end");
                }
                while (masterProducer.isAlive() || !q.isEmpty()) {
                    try {
                        Runnable toRun = q.take();
                        toRun.run();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                        return;
                    }
                }
            });
            consumers[i].start();
        }
        for (int i = 0; i < k; i++) {
            try {
                consumers[i].join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return;
            }
        }
    }

    public static void runWithNRunnablesAndKConsumer(int n, int k) {
        AtomicInteger runId = new AtomicInteger();
        Supplier<Runnable> supplier = () -> () -> System.out
                .println("Here is the " + runId.getAndIncrement() + "-th job for " + Thread.currentThread().getName());
        Runnable[] runnables = Stream
                .generate(supplier)
                .limit(n)
                .toArray(Runnable[]::new);
        long start = System.currentTimeMillis();
        executeInParallel(runnables, k);
        long end = System.currentTimeMillis();
        System.out.printf("Execution with [n = %d, k = %d] takes %d milliseconds.\n", n, k, (end - start));
    }

}

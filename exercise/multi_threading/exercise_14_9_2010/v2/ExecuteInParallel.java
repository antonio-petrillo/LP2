import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class ExecuteInParallel {

    public static void main(String[] args) {
        runWithNRunnablesAndKConsumer(100, 2);
        runWithNRunnablesAndKConsumer(10000, 5);
        runWithNRunnablesAndKConsumer(10000, 50);
    }

    public static void executeInParallel(Runnable[] runnables, int k) {
        Thread[] consumers = new Thread[k];
        BlockingQueue<Runnable> q = new ArrayBlockingQueue<>(k);
        AtomicInteger elementsProcessed = new AtomicInteger();
        IntStream
                .range(0, k)
                .forEach(i -> {
                    consumers[i] = new Thread(() -> {
                        // deadlock
                        while (elementsProcessed.get() < runnables.length) {
                            try {
                                q.take().run();
                                elementsProcessed.incrementAndGet();
                            } catch (InterruptedException ie) {
                                ie.printStackTrace();
                                return;
                            }
                        }
                    });
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
        IntStream.range(0, k).forEach(i -> {
            try {
                consumers[i].join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return;
            }
        });
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

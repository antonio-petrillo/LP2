import java.util.*;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.*;

public class ExecuteInParallel {

    // 1 produttore, k consumatori
    public static void executeInParallel(Runnable[] runnables, int k) {
        BlockingQueue<Runnable> q = new ArrayBlockingQueue<>(k);
        Thread[] threadPoolConsumer = new Thread[k];
        Integer index = Integer.valueOf(0);
        boolean[] done = { false };
        IntStream
                .range(0, k)
                .forEach(i -> {
                    threadPoolConsumer[i] = new Thread(() -> {
                        while (!q.isEmpty() || !done[0]) {
                            try {
                                Runnable r = q.take();
                                r.run();
                            } catch (InterruptedException ie) {
                                ie.printStackTrace();
                                return;
                            }
                        }
                    });
                    threadPoolConsumer[i].start();
                });
        for (Runnable r : runnables) {
            try {
                q.put(r);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return;
            }
        }
        done[0] = true;
        IntStream
                .range(0, k)
                .forEach(i -> {
                    try {
                        threadPoolConsumer[i].join();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                        return;
                    }
                });
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        s.nextLine();
        runWithNRunnablesAndKConsumer(200, 5);
        runWithNRunnablesAndKConsumer(8000, 5);
        runWithNRunnablesAndKConsumer(80000, 500);
        runWithNRunnablesAndKConsumer(8000, 1);
    }

    public static void runWithNRunnablesAndKConsumer(int n, int k) {
        Supplier<Runnable> supplier = () -> (() -> System.out.println("Here is a simple job"));
        Runnable[] runnables = Stream
                .generate(supplier)
                .limit(n)
                .toArray(Runnable[]::new);
        long start = System.currentTimeMillis();
        executeInParallel(runnables, k);
        long end = System.currentTimeMillis();
        System.out.println("\nRun with [ " + n + ", " + k + " ] take " + (end - start) + " millisecond");
    }

}

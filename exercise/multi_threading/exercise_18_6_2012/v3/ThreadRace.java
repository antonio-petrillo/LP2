import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadRace {

    public static void main(String[] args) {
        System.out.println(
                "Thread " + threadRaceV1(() -> System.out.println("Pujaz"), () -> System.out.println("Papujaz")));
        System.out.println(
                "Thread " + threadRaceV2(() -> System.out.println("Pujaz"), () -> System.out.println("Papujaz")));
    }

    public static int threadRaceV1(Runnable r1, Runnable r2) {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(2);
        Thread t1 = new Thread(() -> {
            r1.run();
            q.put(1);
        });
        Thread t2 = new Thread(() -> {
            r2.run();
            q.put(2);
        });
        t1.start();
        t2.start();
        int result = 0;
        try {
            result = q.take();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            throw new RuntimeException("Join failed");
        }
        return result;
    }

    public static int threadRaceV2(Runnable r1, Runnable r2) {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(2);
        Thread t1 = new Thread(() -> {
            r1.run();
            q.put(1);
        });
        Thread t2 = new Thread(() -> {
            r2.run();
            q.put(2);
        });
        t1.start();
        t2.start();
        int result = 0;
        try {
            t1.join();
            t2.join();
            result = q.take();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            throw new RuntimeException("Join failed");
        }
        return result;
    }

}

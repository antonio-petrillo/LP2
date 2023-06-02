import java.util.*;

public class ThreadRace {

    public static void main(String[] args) {
        System.out.println(
                "Thread " + threadRaceV1(() -> System.out.println("Pujaz"), () -> System.out.println("Papujaz")));
        System.out.println(
                "Thread " + threadRaceV2(() -> System.out.println("Pujaz"), () -> System.out.println("Papujaz")));
    }

    public static int threadRaceV1(Runnable r1, Runnable r2) {
        Integer[] result = { Integer.valueOf(0) };
        Thread t1 = new Thread(() -> {
            r1.run();
            synchronized (result) {
                if (result[0] == 0) {
                    result[0] = 1;
                }
                result.notifyAll();
            }
        });
        Thread t2 = new Thread(() -> {
            r2.run();
            synchronized (result) {
                if (result[0] == 0) {
                    result[0] = 2;
                }
                result.notifyAll();
            }
        });
        t1.start();
        t2.start();
        synchronized (result) {
            try {
                result.wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                throw new RuntimeException("Join failed");
            }
        }
        return result[0];
    }

    public static int threadRaceV2(Runnable r1, Runnable r2) {
        Integer[] result = { Integer.valueOf(0) };
        Thread t1 = new Thread(() -> {
            r1.run();
            synchronized (result) {
                if (result[0] == 0) {
                    result[0] = 1;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            r2.run();
            synchronized (result) {
                if (result[0] == 0) {
                    result[0] = 2;
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            throw new RuntimeException("Join failed");
        }
        return result[0];
    }

}

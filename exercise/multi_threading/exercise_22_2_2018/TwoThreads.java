import java.util.*;

public class TwoThreads {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        Thread t1 = new Thread() {

            @Override
            public void run() {
                Random r = new Random();
                int next = r.nextInt();
                while (next % 100 != 0) {
                    synchronized (l) {
                        l.add(next);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                        return;
                    }
                    next = r.nextInt();
                }

            }

        };

        Thread t2 = new Thread() {

            public void run() {
                while (t1.isAlive()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                        return;
                    }
                    synchronized (l) {
                        System.out.println("The sum is: " + l.stream().mapToInt(Integer::intValue).sum());
                    }
                }
            }

        };

        t1.start();
        t2.start();
    }

}

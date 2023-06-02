import java.util.*;
import java.util.concurrent.*;

public class SharedTotal {

    private final Set<Thread> contributors = new HashSet<>();
    private final BlockingQueue<Double> q = new LinkedBlockingQueue<>();
    private final Object monitor = new Object();
    private final Object resultReady = new Object();
    private final long timeout;
    private double result;

    public SharedTotal(int millis) {
        timeout = System.currentTimeMillis() + millis;
        Thread alarm = new Thread(() -> {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return;
            }
            synchronized (monitor) {
                monitor.notifyAll();
            }
        });
        alarm.start();

        Thread produceResult = new Thread(() -> {
            synchronized (monitor) {
                try {
                    monitor.wait();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                    return;
                }
            }
            while (!q.isEmpty()) {
                try {
                    // Funziona perché tipo primitivo?
                    result += q.take();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                    return;
                }
            }
            synchronized (resultReady) {
                resultReady.notifyAll();
            }
        });
        produceResult.start();
    }

    public double sendValAndReceiveTot(double val) throws InterruptedException {
        Thread contributor = Thread.currentThread();
        if (System.currentTimeMillis() > timeout) {
            throw new IllegalArgumentException("Job already ended");
        }
        if (contributors.contains(contributor)) {
            throw new IllegalArgumentException(contributor.getName() + " already contributed");
        }
        q.put(val);
        synchronized (resultReady) {
            resultReady.wait();
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        SharedTotal tot = new SharedTotal(1000);
        // try {
        // System.out.println("result = " + tot.sendValAndReceiveTot(5.0));
        // } catch (InterruptedException ie) {
        // ie.printStackTrace();
        // return;
        // }
        new Thread(() -> {
            try {
                System.out.printf("%s the result is %f\n", Thread.currentThread().getName(),
                        tot.sendValAndReceiveTot(5.0));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return;
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.printf("%s the result is %f\n", Thread.currentThread().getName(),
                        tot.sendValAndReceiveTot(5.0));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return;
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.printf("%s the result is %f\n", Thread.currentThread().getName(),
                        tot.sendValAndReceiveTot(5.0));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return;
            }
        }).start();
    }

}

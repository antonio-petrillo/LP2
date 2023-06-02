import java.util.*;

public class GuessTheNumber {

    private final int secret;
    private final Map<Thread, Integer> players = new HashMap<>();
    private final long timeout;
    private int nearest;
    private final Object monitor = new Object();
    private final Object monitorGuess = new Object();

    public GuessTheNumber(int secret, int millis) {
        this.secret = secret;
        timeout = System.currentTimeMillis() + millis;
        new Thread(() -> {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException ie) {
                return;
            }
            synchronized (monitor) {
                monitor.notifyAll();
            }
        }).start();
    }

    public boolean guessAndWait(int guess) throws InterruptedException {
        // see un thread arriva troppo tardi gli viene risposto false
        if (System.currentTimeMillis() > timeout) {
            return false;
        }
        synchronized (monitorGuess) {
            if (Math.abs(secret - guess) <= Math.abs(secret - nearest)) {
                nearest = guess;
            }
        }
        synchronized (monitor) {
            monitor.wait();
        }
        // se piú thread arrivano `ugualmente vicini` condividono la vittoria
        return guess == nearest;
    }

    public static void main(String[] args) {
        var gtn = new GuessTheNumber(14, 1000);
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread() + " you : " + (gtn.guessAndWait(10) ? "win" : "lose"));
            } catch (InterruptedException ie) {
                return;
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread() + " you : " + (gtn.guessAndWait(13) ? "win" : "lose"));
            } catch (InterruptedException ie) {
                return;
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread() + " you : " + (gtn.guessAndWait(13) ? "win" : "lose"));
            } catch (InterruptedException ie) {
                return;
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread() + " you : " + (gtn.guessAndWait(19) ? "win" : "lose"));
            } catch (InterruptedException ie) {
                return;
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread() + " you : " + (gtn.guessAndWait(1) ? "win" : "lose"));
            } catch (InterruptedException ie) {
                return;
            }
        }).start();
    }

}

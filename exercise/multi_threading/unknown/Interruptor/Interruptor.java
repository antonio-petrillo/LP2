import java.util.Random;

public class Interruptor {

    private int seconds;
    private Thread t;

    public Interruptor(Thread t, int seconds) {
        this.t = t;
        this.seconds = seconds;
        Thread timer = new Thread(() -> {
            try {
                Thread.sleep(seconds * 1000);
            } catch (Throwable e) {
                System.out.println("Error " + e.getMessage());
                e.printStackTrace();
            }
            t.interrupt();
        });
        timer.start();
    }

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Random r = new Random();
            int n = 500;
            while (!Thread.currentThread().isInterrupted()) {
                int sleep = r.nextInt() % n;
                if (sleep < 0) {
                    sleep += n;
                }
                try {
                    Thread.sleep(sleep);
                    System.out.println("papujaz from thread");
                } catch (InterruptedException ie) {
                    System.out.println("Someone interrupted me");
                    Thread.currentThread().interrupt();
                }
            }
        });
        t.start();
        Interruptor i = new Interruptor(t, 10);
    }

}

import java.util.*;

public class StringQuiz {

    private final String secret;
    private final int timeout;
    private final long startTime;
    private final Map<Thread, Integer> attempts = new HashMap<>();
    private final Object monitor = new Object();

    public StringQuiz(String secret, int timeout) {
        this.secret = secret;
        this.timeout = timeout;
        this.startTime = System.currentTimeMillis();
    }

    public boolean guess(String guess) throws RuntimeException {
        if (System.currentTimeMillis() - startTime > timeout) {
            throw new RuntimeException("Tempo scaduto");
        }
        Thread player = Thread.currentThread();
        boolean result = false;
        synchronized (monitor) {
            if (attempts.getOrDefault(player, 0) >= 3) {
                throw new RuntimeException("Troppi tentativi errati");
            }
            attempts.put(player, attempts.getOrDefault(player, 0) + 1);
            result = secret.equals(guess);
        }
        return result;
    }

    public static void main(String[] args) {
        StringQuiz sq = new StringQuiz("Papapujaz", 1000);
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " guess " + sq.guess("Pujaz"));
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " guess " + sq.guess("Papapujaz"));
        });
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " guess " + sq.guess("Pujaz"));
            System.out.println(Thread.currentThread().getName() + " guess " + sq.guess("Pujaz"));
            System.out.println(Thread.currentThread().getName() + " guess " + sq.guess("Pujaz"));
            System.out.println(Thread.currentThread().getName() + " guess " + sq.guess("Pujaz"));
        });
        Thread t4 = new Thread(() -> {
            try {
                Thread.sleep(1001);
                System.out.println(Thread.currentThread().getName() + " guess " + sq.guess("Papapujaz"));
            } catch (InterruptedException ie) {
            }
        });
        t1.start();
        t2.start();
        try {
            t3.start();
        } catch (RuntimeException re) {

        }
        t4.start();
    }

}

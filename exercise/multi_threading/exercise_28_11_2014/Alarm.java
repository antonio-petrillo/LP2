public class Alarm {

    private long elapsedTime;
    private long startAt;
    private final long timeout;
    private Thread timer;
    private final Object monitor = new Object();

    public Alarm(int timeout) {
        this.timeout = timeout * 1000;
    }

    public void anomalyStart() {
        synchronized (monitor) {
            if (timer != null)
                return;
            timer = new Thread(() -> {
                long remaining = timeout - elapsedTime;
                startAt = System.currentTimeMillis();
                try {
                    Thread.sleep(remaining);
                } catch (InterruptedException ie) {
                    return;
                }
                System.out.println("Alarm!");
            });
            timer.start();
        }
    }

    public void anomalyEnd() {
        synchronized (monitor) {
            if (timer != null) {
                timer.interrupt();
                elapsedTime = System.currentTimeMillis() - startAt;
                timer = null;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Alarm a = new Alarm(5);
        a.anomalyStart();
        Alarm b = new Alarm(3);
        b.anomalyStart();
        Thread.sleep(1000);
        b.anomalyEnd();
        b.anomalyStart();
    }

}

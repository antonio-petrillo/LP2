public class PeriodicTask {

    public static void main(String[] args) {
        // Runnable r = new Runnable() {
        // public void run() {
        // System.out.println("ciao");
        // }
        // };
        // Runnable r = () -> System.out.println("ciao");
        // periodicTask(r, 2000);
        periodicTask(() -> System.out.println("ciao"), 2000);
    }

    public static void periodicTask(Runnable r, int millis) {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                Thread newTask = new Thread(r);
                newTask.start();
            }
        });
        t.start();
    }

}

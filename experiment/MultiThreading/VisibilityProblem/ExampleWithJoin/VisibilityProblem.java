
public class VisibilityProblem {
    static boolean done;
    static int n;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            public void run() {
                n = 42;
                try {
                    sleep(1000);
                } catch (InterruptedException ie) {
                    return;
                }
                done = true;
                System.out.println("Fatto");
            }
        };
        t.start();
        t.join();
        System.out.println(n);
    }

}

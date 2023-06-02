
public class VisibilityProblem {
    static volatile boolean done;
    static int n;

    public static void main(String[] args) {
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
        while (!done) {

        }
        System.out.println(n);
    }

}

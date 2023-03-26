import java.util.Timer;

public class Exam {

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {

            public void run() {
                System.out.println("Hello");
            }

        };
        Runnable r2 = new Runnable() {

            public void run() {
                System.out.println("World");
            }

        };
        var pt1 = new PeriodicTask(r1, 2000);
        var pt2 = new PeriodicTask(r2, 4000);

        System.out.println("pt1 == pt2 ? => " + pt1.equals(pt2));
    }

}

class PeriodicTask {
    private int milliSecond;
    // private Runnable r; // not used in valid equals

    public PeriodicTask(Runnable r, int milliSecond) {
        this.milliSecond = milliSecond;
        Runnable timer = new Runnable() {

            public void run() {
                do {
                    r.run();
                    try {
                        Thread.sleep(milliSecond);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while (true);
            }

        };
        Thread t = new Thread(timer);
        t.start();
    }

    @Override
    public boolean equals(Object other) {
        // criteria a, is not valid
        // a PeriodicTask with period greater that 1 second is not equal to itself
        // hence it is not reflexive

        // criteria b, is valid
        if (!(other instanceof PeriodicTask)) {
            return false;
        }

        PeriodicTask pt = (PeriodicTask) other;
        if (milliSecond > pt.milliSecond) {
            return milliSecond % pt.milliSecond == 0;
        } else {
            return pt.milliSecond % milliSecond == 0;
        }

        // criteria c, is not transitive
        // Pick A,B,C such that A and B are equal for the period, B and C are equal for
        // the Runnable, then
        // A == B, B == C, but A != C
    }

}

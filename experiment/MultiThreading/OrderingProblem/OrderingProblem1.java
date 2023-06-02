public class OrderingProblem1 {

    private static int a = 0, b = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                int r1;
                r1 = b;
                a = 1;
                System.out.println("r1 := " + r1);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                int r2;
                r2 = a;
                b = 1;
                System.out.println("r2 := " + r2);
            }
        };
        t1.start();
        t2.start();
    }

}

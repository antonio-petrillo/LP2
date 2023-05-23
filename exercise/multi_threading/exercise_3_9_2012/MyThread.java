public class MyThread extends Thread {

    private int id;
    private Thread other;

    public MyThread(int n, Thread t) {
        id = n;
        other = t;
    }

    public void run() {
        try {
            if (other != null) {
                other.join();
            }
        } catch (InterruptedException e) {
            return;
        }
        System.out.println(id);
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread(1, null);
        Thread t2 = new MyThread(2, null);
        Thread t3 = new MyThread(3, t1);
        Thread t4 = new MyThread(4, t2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    // tutte le permutazioni di 1, 2, 3, 4 in cui 3 viene dopo 1 e 4 viene dopo 2

}

public class MisteryThread6 {
    public static void main(String[] args) throws InterruptedException {
        final Object x = new Object();
        final int[] count = new int[1];
        class MyThread extends Thread {
            int id;

            MyThread(int n) {
                id = n;
            }

            public void run() {
                synchronized (x) {
                    count[0]++;
                    synchronized (count) {
                        count.notify();
                    }
                    try {
                        x.wait();
                    } catch (Exception e) {
                    }
                }
                System.out.println(id);
            }
        }
        Thread t1 = new MyThread(1), t2 = new MyThread(2), t3 = new MyThread(3);
        t1.start();
        t2.start();
        t3.start();
        synchronized (count) {
            while (count[0] < 3) {
                count.wait();
                System.out.println("Incremento");
                // stampa 3 volte incremento
            }
        }
        System.out.println("Fatto");
        synchronized (x) {
            // sveglia tutti i thread sospesi
            x.notifyAll();
        }
        // sequenze:
        // // NOTA gli incr possono variare da 1 a 3
        // incremento
        // incremento
        // incremento
        // fatto
        // tutte le combinazioni di {1,2,3}
    }
}

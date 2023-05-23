public class Driver {

    public static void main(String[] args) {
        Thread t = new ThreadExample();
        t.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 16; i++) {
                try {
                    Thread.sleep(750);
                    System.out.println("Hi from lambda thread!");
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        });
        t2.start();
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(3000);
                System.out.println("Hi from main thread!");
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("End of main thread");

    }

}

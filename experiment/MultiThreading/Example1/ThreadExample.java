
public class ThreadExample extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            try {
                Thread.sleep(1500);
                System.out.println("Hi from thread!");
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("End of thread");
    }

}

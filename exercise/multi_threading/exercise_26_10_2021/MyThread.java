public class MyThread extends Thread {

    public void run() {
        // 1
        for (int i = 0; i < a.length; i++) {
            // 2
            if (a[i] > b[i]) {
                int temp = b[i];
                b[i] = a[i];
                a[i] = temp;
            }
            // 3
        }
        // 4
    }

    // C

}

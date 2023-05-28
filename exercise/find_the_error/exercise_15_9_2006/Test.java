//class Test extends Runnable { // runnable is interface not a class
class Test implements Runnable {
    private Thread thread;

    public Test() {
        thread = new Thread(); // no runnable provided.
        // Thread is abstract
    }

    // public run() { // missing return type
    public void run() { // missing return type
        int i = 0;
        for (i=0; i<10 ;i++)
            System.out.println(" i = " + i);
    }

    public static void main(String args[]) {
        Test t = new Test();
        t.start(); // T is not a thread but a Runnbale
    }
}

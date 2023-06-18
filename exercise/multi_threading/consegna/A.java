
public class A {

    private volatile int n;

    public int incrementAndGet() {
        return ++n;
    }

    public static void main(String[] args) {
        A a = new A();
        A b = new A();
        Thread t1 = new Thread(() -> System.out.println(a.incrementAndGet()));
        Thread t2 = new Thread(() -> System.out.println(b.incrementAndGet()));
        Thread t3 = new Thread(() -> System.out.println(a.incrementAndGet()));
        t1.start();
        t2.start();
        t3.start();
    }

}

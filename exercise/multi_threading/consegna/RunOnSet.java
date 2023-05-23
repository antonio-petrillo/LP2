import java.util.*;

public class RunOnSet<T> extends Thread {

    private RunnableWithArg<T> r;
    private Collection<T> c;

    public RunOnSet(RunnableWithArg<T> r, Collection<T> c) {
        this.r = r;
        this.c = c;
    }

    public void run() {
        Thread[] threads = new Thread[c.size()];
        int i = 0;
        for (T t : c) {
            threads[i++] = new Thread(() -> {
                r.run(t);
            });
            threads[i - 1].start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Collection<Integer> s = new HashSet<Integer>();
        s.add(3);
        s.add(13);
        s.add(88);
        s.add(97);

        System.out.println("classe anonima");
        RunnableWithArg<Integer> r = new RunnableWithArg<Integer>() {
            public void run(Integer i) {
                System.out.println(i / 2);
            }
        };
        Thread t = new RunOnSet<Integer>(r, s);
        t.start();
        Thread.sleep(1000);

        System.out.println("\nlambda function");
        r = (i) -> System.out.println(i / 2);
        t = new RunOnSet<Integer>(r, s);
        t.start();
        Thread.sleep(1000);

        System.out.println("\nmethod reference");
        t = new RunOnSet<Integer>(r::run, s);
        t.start();
    }

}

@FunctionalInterface
interface RunnableWithArg<T> {
    void run(T x);
}

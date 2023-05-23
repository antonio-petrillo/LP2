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
        RunnableWithArg<Integer> r = new RunnableWithArg<Integer>() {
            public void run(Integer i) {
                System.out.println(i / 2);
            }
        };
        Thread t = new RunOnSet<Integer>(r, s);
        t.start();
        Thread.sleep(1000);
        r = (i) -> System.out.println(i / 2);
        t = new RunOnSet<Integer>(r, s);
        t.start();
        Thread.sleep(1000);
        Pujaz p = new Pujaz();
        t = new RunOnSet<Integer>(p::run, s);
        t.start();
    }

}

class Pujaz implements RunnableWithArg<Integer> {

    public void run(Integer x) {
        System.out.println(x.intValue() / 2);
    }

}

import java.util.*;

public class DoubleQueue<T> {
    private LinkedList<T> l1 = new LinkedList<>();
    private LinkedList<T> l2 = new LinkedList<>();

    public void add(T t) {
        if (l1.size() <= l2.size()) {
            l1.addLast(t);
        } else {
            l2.addLast(t);
        }
    }

    public T remove1() {
        return l1.removeFirst();
    }

    public T remove2() {
        return l2.removeFirst();
    }

    public boolean isEmpty1() {
        return l1.isEmpty();
    }

    public boolean isEmpty2() {
        return l2.isEmpty();
    }

    public static void main(String[] args) {
        DoubleQueue<Integer> q = new DoubleQueue<Integer>();
        q.add(3);
        q.add(5);
        q.add(7);
        System.out.println("Contenuto della prima coda:");
        while (!q.isEmpty1())
            System.out.println(q.remove1());
        System.out.println("Contenuto della seconda coda:");
        while (!q.isEmpty2())
            System.out.println(q.remove2());

    }
}

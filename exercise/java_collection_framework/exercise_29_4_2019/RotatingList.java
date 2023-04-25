import java.util.*;

public class RotatingList<T> {
    private LinkedList<T> list;
    private int size;
    private Set<T> set;

    public RotatingList() {
        list = new LinkedList<>();
        set = new HashSet<>();
    }

    public void add(T t) {
        list.addLast(t);
        if (!set.contains(t))
            set.add(t);
    }

    public void rotateLeft() {
        if (list.size() > 0) {
            T t = list.removeFirst();
            list.addLast(t);
        }
    }

    public void rotateRight() {
        if (list.size() > 0) {
            T t = list.removeLast();
            list.addFirst(t);
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RotatingList)) {
            return false;
        }
        RotatingList<?> l = (RotatingList<?>) o;
        return set.equals(l.set);
    }

    public static void main(String[] args) {
        RotatingList<Integer> l = new RotatingList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(l);
        l.rotateLeft();
        System.out.println(l);
        l.add(4);
        System.out.println(l);
        l.rotateRight();
        System.out.println(l);
    }

}

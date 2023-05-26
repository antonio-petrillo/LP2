import java.util.*;

public class RotatingList<T> implements Comparable<RotatingList<? super t>> {
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

    // criteria a is not valid, it is not consistent
    // l1 = [1, 2, 3], l2 = [2, 1, 3]
    // l1.compareTo(l2) == 0
    // BUT
    // l3 = [3, 2, 1] ->
    // l1.compareTo(l3) == -1 BUT l2.compareTo(l2) = 0

    // criteria b is not valid, it is not consistent
    // l1 = [1, 2, 3], l2 = [3, 2, 1]
    // l1.compareTo(l2) == 0
    // BUT
    // l3 = [1, 2, 3, 4] ->
    // l1.compareTO(l3) == -1 BUT l2.compareTo(l3) == 0

    // criteria c is not valid, it is not antisymmetric
    // l1 = [1 2 3], l2 = [1 2 4]
    // l1.compareTo(l2) == -1
    // l2.compareTo(l1) == -1

    // criteria d is valid
    @Override
    public int compareTo(RotatingList<T> l) {
        int mod1 = list.size() % 2;
        int mod2 = l.size() % 2;
        return mod1 == mod2 ? 0 : (mod1 > mod2 ? 1 : -1);
    }
}

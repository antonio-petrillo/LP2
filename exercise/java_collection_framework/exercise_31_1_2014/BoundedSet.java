import java.util.*;

public class BoundedSet<T> {

    private int maxSize;
    private LinkedList<T> lru;
    private Set<T> set;

    public BoundedSet(int maxSize) {
        this.maxSize = maxSize;
        set = new HashSet<>();
        lru = new LinkedList<>();
    }

    public void add(T t) {
        if (set.size() >= maxSize && !set.contains(t)) {
            set.remove(lru.removeLast());
        }
        set.add(t);
        lru.addFirst(t);
    }

    public void remove(T t) {
        set.remove(t);
        lru.remove(t);
    }

    public boolean contains(Object o) {
        return set.contains(o);
    }

    public int size() {
        return set.size();
    }

    public static void main(String[] args) {
        BoundedSet<Integer> s = new BoundedSet<Integer>(3);
        s.add(3);
        s.add(8);
        s.add(5);
        s.add(5);
        System.out.println(s.size());
        System.out.println(s.contains(3));
        s.add(14);
        System.out.println(s.size());
        System.out.println(s.contains(3));
    }

}

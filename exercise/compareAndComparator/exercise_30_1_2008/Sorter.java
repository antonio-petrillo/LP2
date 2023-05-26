import java.util.*;

public class Sorter<T extends Comparable<? super T>> {

    private T prev;

    public Sorter(T seed) {
        this.prev = seed;
    }

    public int check(T t) {
        T old = prev;
        prev = t;
        return t.compareTo(old);
    }

    public static void main(String[] args) {
        Sorter<Integer> s = new Sorter<Integer>(7);
        System.out.println(s.check(4));
        System.out.println(s.check(1));
        System.out.println(s.check(6));
        System.out.println(s.check(6));
    }

}

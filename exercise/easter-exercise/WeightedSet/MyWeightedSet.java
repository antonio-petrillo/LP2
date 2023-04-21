import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MyWeightedSet<T> {

    private static class Entry<E> implements Comparable<Entry<?>> {
        E element;
        Integer weight;

        Entry(E element, Integer weight) {
            this.element = element;
            this.weight = weight;
        }

        @Override
        public int compareTo(Entry<?> other) {
            return Integer.compare(weight, other.weight);
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private SortedSet<Entry<T>> set;
    private Integer threshold;

    public MyWeightedSet() {
        this.set = new TreeSet<>();
        this.threshold = null;
    }

    private boolean checkThreshold(Integer weight) {
        return threshold == null || threshold != null && weight >= threshold;
    }

    public boolean add(T t, Integer weight) {
        Entry<T> e = new Entry<>(t, weight);
        if (checkThreshold(weight)) {
            if (set.contains(e)) {
                set.remove(e);
            }
            return set.add(e);
        }
        return false;
    }

    private MyWeightedSet(SortedSet<Entry<T>> set, Integer threshold) {
        this.set = set;
        this.threshold = threshold;
    }

    public MyWeightedSet<T> atLeast(Integer threshold) {
        return new MyWeightedSet<T>(set, threshold);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<? extends Entry<?>> iter = set.iterator();
        while (iter.hasNext()) {
            Entry<?> e = iter.next();
            if (checkThreshold(e.weight)) {
                sb.append(e);
                if (iter.hasNext()) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // sed -i -e '90s/ar/er/g' MyWeightedSet.java
    public static void main(String[] args) {
        MyWeightedSet<Object> set = new MyWeightedSet<>();
        set.add(Double.valueOf(3.14), 100);
        set.add(new Object(), 5);
        set.add("Skylar", 50);
        set.add("Jesse", 5);
        System.out.println(set);
        MyWeightedSet<Object> set10 = set.atLeast(10);
        System.out.println(set10);
        set.add("Walter", 60);
        System.out.println(set);
        System.out.println(set10);
    }
}

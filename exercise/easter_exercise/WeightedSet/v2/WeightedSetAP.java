import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class WeightedSet<T> {

    private SortedMap<Integer, T> set;
    private Integer threshold;

    public WeightedSet() {
        this.set = new TreeMap<>();
        this.threshold = null;
    }

    private boolean checkThreshold(Integer weight) {
        return threshold == null || threshold != null && weight >= threshold;
    }

    public T add(T t, Integer weight) {
        if (checkThreshold(weight)) {
            if (set.containsKey(weight)) {
                set.remove(weight);
            }
            return set.put(weight, t);
        }
        return null;
    }

    private WeightedSet(SortedMap<Integer, T> set, Integer threshold) {
        this.set = set;
        this.threshold = threshold;
    }

    public WeightedSet<T> atLeast(Integer threshold) {
        Integer max = threshold == null ? threshold : (this.threshold > threshold ? this.threshold : threshold);
        return new WeightedSet<T>(set, max);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Integer> iter = set.keySet().iterator();
        while (iter.hasNext()) {
            Integer key = iter.next();
            if (checkThreshold(key)) {
                sb.append(set.get(key).toString());
                if (iter.hasNext()) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        WeightedSet<Object> set = new WeightedSet<>();
        set.add(Double.valueOf(3.14), 100);
        set.add(new Object(), 5);
        set.add("Skylar", 50);
        set.add("Jesse", 5);
        System.out.println(set);
        WeightedSet<Object> set10 = set.atLeast(10);
        System.out.println(set10);
        set.add("Walter", 60);
        System.out.println(set);
        System.out.println(set10);
    }
}

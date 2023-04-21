import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class WeightedSet<T> {
    private Map<T, Integer> map;
    private int threshold;

    public WeightedSet() {
        map = new HashMap<>();
        threshold = Integer.MIN_VALUE;
    }

    private WeightedSet(Map<T, Integer> map, int threshold) {
        this.map = map;
        this.threshold = threshold;
    }

    public T add(T t, Integer weight) {
        if (weight >= threshold) {
            map.put(t, weight);
        }
        return null;
    }

    public WeightedSet<T> atLeast(int threshold) {
        return new WeightedSet<T>(map, threshold);
    }

    @Override
    public String toString() {
        ArrayList<T> list = new ArrayList<>();
        for (T t : map.keySet()) {
            if (map.get(t) >= threshold) {
                list.add(t);
            }
        }
        Collections.sort(list, (a, b) -> Integer.compare(map.get(a), map.get(b)));
        return list.toString();
    }

    public static void main(String[] args) {
        WeightedSet<Object> set = new WeightedSet<Object>();
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

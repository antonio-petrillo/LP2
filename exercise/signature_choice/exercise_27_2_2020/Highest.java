import java.util.*;

public class Highest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 5);
        map.put("b", 3);
        map.put("c", 0);
        map.put("d", 5);
        System.out.println("highest keys := " + Highest.<String, Integer>keysWithHighestValue(map, Integer::compare));
    }

    public static <K, V> Set<K> keysWithHighestValue(Map<? extends K, ? extends V> m, Comparator<? super V> c) {
        Set<K> set = new HashSet<>();
        V max = Highest.<V>getMaxValue(m.values(), c);
        for (K k : m.keySet()) {
            if (c.compare(m.get(k), max) == 0) {
                set.add(k);
            }
        }
        return set;
    }

    private static <T> T getMaxValue(Collection<? extends T> coll, Comparator<? super T> c) {
        T max = null;
        for (T t : coll) {
            if (max == null) {
                max = t;
            } else {
                if (c.compare(t, max) > 0) {
                    max = t;
                }
            }
        }
        return max;
    }

}

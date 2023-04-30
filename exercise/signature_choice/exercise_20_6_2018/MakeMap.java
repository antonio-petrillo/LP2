import java.util.*;

public class MakeMap {

    public static void main(String[] args) {
        List<Integer> ks = List.of(1, 2, 3, 4, 5);
        List<Double> vs = List.of(1., 2., 3., 4., 5.);
        System.out.println("map => " + MakeMap.<Integer, Double>makeMap(ks, vs));
    }

    public static <K, V> Map<K, V> makeMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("lists size doesn't match");
        }
        Map<K, V> map = new HashMap<>();
        Iterator<? extends V> iterVals = values.iterator();
        for (K k : keys) {
            if (map.containsKey(k)) {
                throw new IllegalArgumentException("duplicate keys");
            }
            map.put(k, iterVals.next());
        }
        return map;
    }

}

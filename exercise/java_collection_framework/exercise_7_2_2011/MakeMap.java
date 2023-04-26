
// aka zip in haskell/clojure
import java.util.*;

public class MakeMap {

    public static void main(String[] args) {
        List<Integer> keys = new LinkedList<>();
        keys.add(1);
        keys.add(2);
        keys.add(3);
        List<String> values = new LinkedList<>();
        values.add("pujaz");
        values.add("pujaz");
        values.add("pujaz");
        System.out.println(MakeMap.<Integer, String>makeMap(keys, values));
    }

    public static <K, V> Map<K, V> makeMap(List<K> keys, List<V> values) {

        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("the two lists doesn't match");
        }

        Map<K, V> map = new HashMap<>();
        Iterator<V> iter = values.iterator();
        for (K k : keys) {
            if (map.containsKey(k)) {
                throw new IllegalArgumentException("duplicate keys");
            }
            map.put(k, iter.next());
        }

        return map;
    }

}

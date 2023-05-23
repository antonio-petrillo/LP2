import java.util.*;

public class BoundedMap<K, V> {

    private Map<K, V> map;
    private Map<K, Integer> hits;
    private int maxSize;

    public BoundedMap(int maxSize) {
        this.maxSize = maxSize;
        hits = new HashMap<>();
        map = new HashMap<>();
    }

    private K getMinimumHits() {
        K minKey = null;
        Integer minValue = Integer.MAX_VALUE, tmp;
        for (K k : hits.keySet()) {
            tmp = hits.get(k);
            if (tmp <= minValue) {
                minKey = k;
                minValue = tmp;
            }
        }
        return minKey;
    }

    public void put(K k, V v) {
        if (map.size() >= maxSize && !map.containsKey(k)) {
            K min = getMinimumHits();
            map.remove(min);
            hits.remove(min);
        }
        map.put(k, v);
        hits.put(k, 1);
    }

    public V get(K k) {
        if (map.containsKey(k)) {
            Integer value = hits.get(k);
            hits.put(k, value + 1);
        }
        return map.get(k);
    }

    public void remove(K k) {
        map.remove(k);
        hits.remove(k);
    }

    public int size() {
        return map.size();
    }

    public static void main(String[] args) {
        BoundedMap<String, String> m = new BoundedMap<String, String>(2);
        m.put("NA", "Napoli");
        m.put("SA", "Salerno");
        System.out.println(m.get("NA"));
        m.put("AV", "Avellino");
        System.out.println(m.get("SA"));
    }

}

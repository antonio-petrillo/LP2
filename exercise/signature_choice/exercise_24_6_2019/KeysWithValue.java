import java.util.*;

public class KeysWithValue {

    // funzionale, non completa, corretta, troppi parametri di tipo, nessuna
    // garanzia
    public static <K, V> void keysWithValueA(Map<K, V> m, V value, List<K> out) {
        for (K k : m.keySet()) {
            if (value.equals(m.get(k)))
                out.add(k);
        }
    }

    // funzionale, non completa, corretta, semplice, poche garanzie
    public static <K> void keysWithValueB(Map<K, ?> m, Object value, List<Object> out) {
        for (K k : m.keySet()) {
            if (value.equals(m.get(k)))
                out.add(k);
        }
    }

    // funzionale, non completa, corretta, semplice, poche garanzie
    public static <K, V> void keysWithValueC(Map<? extends K, V> m, V value, List<K> out) {
        for (K k : m.keySet()) {
            if (value.equals(m.get(k)))
                out.add(k);
        }
    }

    // non funzionale
    // public static <K, V> void keysWithValueD(Map<? extends K, V> m, V value,
    // List<? extends K> out) {
    // }

    // non funzionale
    // public static <V> void keysWithValueD(Map<?, V> m, V value, List<?> out) {
    // }

    // funzionale, non completa, corretta, semplice, molte (ma non tutte) garanzie
    public static <K> void keysWithValueE(Map<K, ?> m, Object value, LinkedList<? super K> out) {
        for (K k : m.keySet()) {
            if (value.equals(m.get(k)))
                out.add(k);
        }
    }

    // BEST
    public static <K> void keysWithValueF(Map<? extends K, ?> m, Object value, LinkedList<? super K> out) {
        for (K k : m.keySet()) {
            if (value.equals(m.get(k)))
                out.add(k);
        }
    }

}

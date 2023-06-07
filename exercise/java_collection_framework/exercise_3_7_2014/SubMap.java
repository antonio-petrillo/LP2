import java.util.*;

public class SubMap {

    // funzionale, non completa, corretta, poche garanzie, semplice,tipo di ritorno
    // poco
    // utile
    public static <K> Map<K, ?> subMap(Map<K, ?> m, Collection<K> c) {
        return null;
    }

    // funzionale, completa, corretta, poche garanzie, semplice, tipo di ritorno
    // utile
    public static <K, V> Map<K, V> subMap(Map<K, V> m, Collection<?> c) {
        return null;
    }

    // funzionale, completa, corretta, poche garanzie, semplice, tipo di ritorno
    // utile
    public static <K, V> Map<K, V> subMap(Map<K, V> m, Collection<? super K> c) {
        return null;
    }

    // funzionale, completa, corretta, poche garanzie, semplice, tipo di ritorno
    // utile
    public static <K, V> Map<K, V> subMap(Map<K, V> m, Collection<? extends K> c) {
        return null;
    }

    // non funzionale, la traccia specifica che il metodo deve accettare Collection;
    // public static <K, V> Map<K, V> subMap(Map<K, V> m, Set<K> c) {
    // return null;
    // }

    // funzionale, completa, corretta, non semplice, nessuna garanzia.
    public static <K, V, K2 extends K> Map<K, V> subMap(Map<K, V> m, Collection<K2> c) {
        return null;
    }

    // BEST
    // implemento solo questa per semplicitá
    public static <K, V> Map<K, V> subMap(Map<? extends K, ? extends V> m, Collection<?> c) {
        return new Map<K, V>() {

            public V get(Object k) {
                if (validKeys.contains(k))
                    return m.get(k);
                return null;
            }

            public V put(K k, V v) {
                throw new UnsupportedOperationException("SubMap is immutable");
            }

            // a looooooooooot of code for the others method.

        };
    }
}

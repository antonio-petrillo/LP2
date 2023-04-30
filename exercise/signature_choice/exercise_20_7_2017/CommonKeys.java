import java.util.*;

public class CommonKeys {

    public static void main(String[] args) {
        Map<Integer, String> m1 = new HashMap<>();
        Map<Integer, String> m2 = new HashMap<>();
        m1.put(1, "ciao");
        m2.put(1, "ciao");
        m1.put(2, "ciao");
        m2.put(2, "ciao");
        m1.put(3, "ciao");
        m2.put(3, "ciao");
        m2.put(4, "ciao");
        m1.put(0, "ciao");
        m1.put(5, "ciao");
        m2.put(6, "ciao");
        System.out.println(CommonKeys.<Integer>commonKeysA(m1, m2));
        System.out.println(CommonKeys.<Integer, String, String>commonKeysB(m1, m2));
        System.out.println(commonKeysC(m1, m2));
        System.out.println(CommonKeys.<Integer>commonKeysD(m1, m2));
        System.out.println(CommonKeys.<Integer>commonKeysE(m1, m2));
    }

    // funzionale, non completa, corretta, non posso modificare la mappa, abbastanza
    // semplice
    public static <T> Set<T> commonKeysA(Map<T, ?> m1, Map<T, ?> m2) {
        Set<T> set = new HashSet<>();
        for (T t : m1.keySet()) {
            if (m2.containsKey(t)) {
                set.add(t);
            }
        }
        return set;
    }

    // funzionale, non completa, corretta, nessuna garanzia, non semplice
    public static <T, V1, V2> Set<T> commonKeysB(Map<T, V1> m1, Map<T, V2> m2) {
        Set<T> set = new HashSet<>();
        for (T t : m1.keySet()) {
            if (m2.containsKey(t)) {
                set.add(t);
            }
        }
        return set;
    }

    // funzionale, completa, corretta, non posso modificare le mappe, molto semplice
    // purtroppo il tipo di ritorno non é utile al chiamante
    public static Set<Object> commonKeysC(Map<?, ?> m1, Map<?, ?> m2) {
        Set<Object> set = new HashSet<>();
        for (Object o : m1.keySet()) {
            if (m2.containsKey(o)) {
                set.add(o);
            }
        }
        return set;
    }

    // la migliore finora
    // funzionale, completa, corretta, semplice, garanzie di non modificare la mappa
    // il tipo di ritorno puó essere utilizzato dal chiamante, il che non é un male
    // anche Set<T> poteva essere accettabile, anzi forse migliore
    public static <T> Set<? extends T> commonKeysD(Map<? extends T, ?> m1, Map<? extends T, ?> m2) {
        Set<T> set = new HashSet<>();
        for (T t : m1.keySet()) {
            if (m2.containsKey(t)) {
                set.add(t);
            }
        }
        return set;
    }

    // funzionale, completa, corretta, semplice, il tipo di ritorno non é utile al
    // chiamante
    public static <T> Set<?> commonKeysE(Map<T, ?> m1, Map<?, ?> m2) {
        Set<Object> set = new HashSet<>();
        for (Object o : m1.keySet()) {
            if (m2.containsKey(o)) {
                set.add(o);
            }
        }
        return set;
    }
}

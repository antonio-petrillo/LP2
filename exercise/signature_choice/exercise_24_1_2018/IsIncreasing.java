import java.util.*;

public class IsIncreasing {

    public static void main(String[] args) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(1, 2);
        m.put(2, 2);
        m.put(3, 3);
        m.put(4, 5);
        System.out.println(IsIncreasing.<Integer>isIncreasing(m, Integer::compare));
        m.put(5, 4);
        System.out.println(IsIncreasing.<Integer>isIncreasing(m, Integer::compare));
    }

    public static <T> boolean isIncreasing(Map<? extends T, ? extends T> m, Comparator<? super T> c) {
        for (T t : m.keySet()) {
            if (c.compare(t, m.get(t)) > 0) {
                return false;
            }
        }
        return true;
    }

    // Non funzionale, non posso comparare chiavi e valori
    // a) <K,V> boolean isIncreasing(Map<K,V> m, Comparator<K> c)

    // Non funzionale, non posso comparare chiavi e valori
    // b) <K,V> boolean isIncreasing(Map<K,V> m, Comparator<? super K> c)

    // funzionale, completa, corretta, no garanzie, semplice, ma non il piú semplice
    // possibile
    // c) <K,V extends K> boolean isIncreasing(Map<K,V> m, Comparator<? super K> c)

    // funzionale, non completa, corretta, no garanzie, semplice
    // d) <T> boolean isIncreasing(Map<T,T> m, Comparator<T> c)

    // non funzionale, c accetta solo null;
    // e) <T> boolean isIncreasing(Map<T,T> m, Comparator<? extends T> c)

}

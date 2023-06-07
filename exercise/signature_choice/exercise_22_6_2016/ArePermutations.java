import java.util.*;

public class ArePermutations {
    // funzionale, completa, corretta, molte garanzie, semplice
    public static boolean arePermutations(List<?> a, List<?> b) {
        Map<?, Integer> countA = count(a);
        Map<?, Integer> countB = count(b);
        return mapEquals(countA, countB);
    }

    // funzionle, completa, corretta, no garanzie, non semplice
    public static <S, T> boolean arePermutations(List<S> a, List<T> b) {
        Map<?, Integer> countA = count(a);
        Map<?, Integer> countB = count(b);
        return mapEquals(countA, countB);
    }

    // funzionale, non completa, corretta, no garanzie, potrebbe essere piú semplice
    public static <S> boolean arePermutations(List<S> a, List<S> b) {
        Map<?, Integer> countA = count(a);
        Map<?, Integer> countB = count(b);
        return mapEquals(countA, countB);
    }

    // funzionale, non completa, corretta, molte garanzie, potrebbe essere piú
    // semplice
    public static <S> boolean arePermutations(List<? extends S> a, List<? extends S> b) {
        Map<?, Integer> countA = count(a);
        Map<?, Integer> countB = count(b);
        return mapEquals(countA, countB);
    }

    // funzionale, non completa, corretta, nessuna garanzie, semplice
    public static boolean arePermutations(List<Object> a, List<Object> b) {
        Map<?, Integer> countA = count(a);
        Map<?, Integer> countB = count(b);
        return mapEquals(countA, countB);
    }

    // funzionale, non completa, corretta, molte garanzie, potrebbe essere piú
    // semplice
    public static <S, T extends S> boolean arePermutations(List<? extends S> a, List<? extends T> b) {
        Map<?, Integer> countA = count(a);
        Map<?, Integer> countB = count(b);
        return mapEquals(countA, countB);
    }

    private static Map<?, Integer> count(List<?> l) {
        Map<Object, Integer> m = new HashMap<>();
        for (Object o : l) {
            m.put(o, m.getOrDefault(o, 1) + 1);
        }
        return m;
    }

    private static boolean mapEquals(Map<?, ?> m1, Map<?, ?> m2) {
        if (m1.keySet().size() != m2.keySet().size())
            return false;
        for (Object key : m1.keySet())
            if (!m1.get(key).equals(m2.get(key)))
                return false;
        return true;
    }
}

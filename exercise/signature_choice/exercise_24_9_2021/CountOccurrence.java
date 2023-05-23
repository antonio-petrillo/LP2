import java.util.*;

public class CountOccurrence {

    public static void main(String[] args) {
        List<Object> l = List.of("ciao", "mondo", "ciao", "mondo", "mondo", "pujaz", "sucuzzone", Integer.valueOf(1),
                Integer.valueOf(2));
        System.out.println("C" + CountOccurrence.countOccurrencesC(l));
        System.out.println("D" + CountOccurrence.<Object, Object>countOccurrencesD(l));
        System.out.println("E" + CountOccurrence.<Object>countOccurrencesE(l));
        System.out.println("F" + CountOccurrence.countOccurrencesF(l));
        System.out.println("Best" + CountOccurrence.<Object>countOccurrencesBest(l));
    }

    // non funzionale
    // nella mappa di ritorno posso solo inserire Object, che non é compatibile con
    // K
    // public static <K> Map<? extends K, Integer>
    // countOccurrencesA(Collection<Object> c) {
    // return null;
    // }

    // non fuzionale
    // nella mappa di ritorno posso solo inserire Object (perché da Collection<?
    // super K> posso solo ottener Object)
    // public static <K> Map<? extends K, Integer> countOccurrencesB(Collection<?
    // super K> c) {
    // return null;
    // }

    // funzionale, non completa, corretta, semplice nessuna garanzia ulteriore
    public static Map<Object, Integer> countOccurrencesC(Collection<Object> c) {
        Map<Object, Integer> m = new HashMap<>();
        for (Object o : c) {
            if (m.containsKey(o)) {
                int val = m.get(o);
                m.put(o, val + 1);
            } else {
                m.put(o, 1);
            }
        }
        return m;
    }

    // funzionale, completa, corretta, nessuna garanzia extra, non semplice accetta
    // due parametri di cui uno superfluo
    public static <S, T extends S> Map<S, Integer> countOccurrencesD(Collection<T> c) {
        Map<S, Integer> m = new HashMap<>();
        for (S s : c) {
            if (m.containsKey(s)) {
                int val = m.get(s);
                m.put(s, val + 1);
            } else {
                m.put(s, 1);
            }
        }
        return m;
    }

    // funzionale, completa, corretta, non posso modificare la collezzione
    // originale, semplice.
    // purtroppo il tipo di ritorno non é utile al chiamante
    public static <K> Map<? super K, Integer> countOccurrencesE(Collection<? extends K> c) {
        Map<K, Integer> m = new HashMap<>();
        for (K k : c) {
            if (m.containsKey(k)) {
                int val = m.get(k);
                m.put(k, val + 1);
            } else {
                m.put(k, 1);
            }
        }
        return m;
    }

    // funzionale, completa, corretta, semplice, non posso modificare c
    // purtroppo il tipo di ritorno non é utile al chiamante
    public static Map<Object, Integer> countOccurrencesF(Collection<?> c) {
        Map<Object, Integer> m = new HashMap<>();
        for (Object o : c) {
            if (m.containsKey(o)) {
                int val = m.get(o);
                m.put(o, val + 1);
            } else {
                m.put(o, 1);
            }
        }
        return m;
    }

    public static <K> Map<K, Integer> countOccurrencesBest(Collection<? extends K> c) {
        Map<K, Integer> m = new HashMap<>();
        for (K k : c) {
            if (m.containsKey(k)) {
                int val = m.get(k);
                m.put(k, val + 1);
            } else {
                m.put(k, 1);
            }
        }
        return m;
    }

}

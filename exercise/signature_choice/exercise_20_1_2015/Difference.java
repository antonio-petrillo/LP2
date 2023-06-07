import java.util.*;

public class Difference {

    // funzionale, completa, corretta, semplice, molte garanzie, tipo di ritorno
    // poco utile
    public static Set<?> differenceA(Set<?> a, Set<?> b) {
        Set<Object> diff = new HashSet<>();
        for (Object t : a) {
            if (!b.contains(t))
                diff.add(t);
        }
        return diff;
    }

    // funzionale, completa, corretta, semplice, molte garanzie, tipo di ritorno
    // poco utile
    public static Set<Object> differenceB(Set<?> a, Set<?> b) {
        Set<Object> diff = new HashSet<>();
        for (Object t : a) {
            if (!b.contains(t))
                diff.add(t);
        }
        return diff;
    }

    // non funzionale, il metodo deve accettare insiemi arbitrari
    // public static Set<Object> differenceC(Set<String> a, Set<String> b) {
    // return null;
    // }

    // funzionale, completa, corretta, no garanzie su a, semplice
    public static <T> Set<T> differenceD(Set<T> a, Set<?> b) {
        Set<T> diff = new HashSet<>();
        for (T t : a) {
            if (!b.contains(t))
                diff.add(t);
        }
        return diff;
    }

    // funzionale, non completa (non accetta due insiemi arbitrari), corretta,
    // garanzie, semplice
    public static <T> Set<T> differenceE(Set<? extends T> a, Set<? extends T> b) {
        Set<T> diff = new HashSet<>();
        for (T t : a) {
            if (!b.contains(t))
                diff.add(t);
        }
        return diff;
    }

    // funzionale, non completa (non accetta due insiemi arbitrari), corretta,
    // garanzie, semplice
    public static <T> Set<T> differenceF(Set<T> a, Set<? extends T> b) {
        Set<T> diff = new HashSet<>();
        for (T t : a) {
            if (!b.contains(t))
                diff.add(t);
        }
        return diff;
    }

    // BEST
    public static <T> Set<T> differenceF(Set<? extends T> a, Set<?> b) {
        Set<T> diff = new HashSet<>();
        for (T t : a) {
            if (!b.contains(t))
                diff.add(t);
        }
        return diff;
    }
}

import java.util.*;

public class Disjoin {

    // GOOD
    public static <T> Set<T> disjoin(Collection<? extends T> c1, Collection<?> c2) {
        Set<T> commons = new HashSet<>();
        for (T t : c1) {
            if (c2.contains(t)) {
                c1.remove(t);
                c2.remove(t);
                commons.add(t);
            }
        }
        return commons;
    }

    // Almost Best, the return type ruins it
    public static Set<Object> disjoin(Collection<?> c1, Collection<?> c2) {
        Set<Object> commons = new HashSet<>();
        for (Object o : c1) {
            if (c2.contains(o)) {
                c1.remove(o);
                c2.remove(o);
                commons.add(o);
            }
        }
        return commons;
    }

    // proposed solution
    // funzionale, corretta, non completa, semplice, no garanzie
    public static <S> Set<S> disjoin(Collection<S> c1, Collection<S> c2) {
        Set<S> commons = new HashSet<>();
        for (S o : c1) {
            if (c2.contains(o)) {
                c1.remove(o);
                c2.remove(o);
                commons.add(o);
            }
        }
        return commons;
    }

    // best solution
    // funzionale, corretta, completa, garanzie, semplice
    public static <S> Set<S> disjoin(Collection<? extends S> c1, Collection<?> c2) {
        Set<S> commons = new HashSet<>();
        for (S o : c1) {
            if (c2.contains(o)) {
                c1.remove(o);
                c2.remove(o);
                commons.add(o);
            }
        }
        return commons;
    }

    // funzionale, corretta, non completa, no garanzie, tipo di ritorno non utile
    // firma complicata, il tipo T non serve a nulla
    public static <S, T> Set<? super S> disjoin(Collection<S> c1, Collection<T> c2) {
        Set<S> commons = new HashSet<>();
        for (S s : c1) {
            if (c2.contains(s)) {
                c1.remove(s);
                c2.remove(s);
                commons.add(s);
            }
        }
        return commons;
    }

    // funzionale, corretta, completa, garanzie, tipo di ritorno poco utile, non
    // rispetta la tracia, le list dovrebbero essere collection
    public static Set<Object> disjoin(List<?> c1, List<?> c2) {
        Set<Object> commons = new HashSet<>();
        for (Object o : c1) {
            if (c2.contains(o)) {
                c1.remove(o);
                c2.remove(o);
                commons.add(o);
            }
        }
        return commons;
    }

    // non funzionale, iterando su a e b produco degli object che non possono essere
    // aggiunti a tipo di ritorno;
    // public static <S> Set<S> disjoin(Collection<? super S> a, Collection<? super
    // S> b) {
    // }
}

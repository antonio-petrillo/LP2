import java.util.*;

public class ListIntersection {
    // funzionale, completa, corretta, semplice, molte garanzie, tipo di ritorno
    // poco utile.
    public static List<?> listIntersectionA(List<?> l, Set<?> s) {
        List<Object> res = new ArrayList<>();
        for (Object o : l)
            if (s.contains(o))
                res.add(o);
        return res;
    }

    // funzionale, non completa, corretta, semplice, nessuan garanzia sulla lista,
    // tipo di ritorno poco utile
    public static List<Object> listIntersectionB(List<Object> l, Set<?> s) {
        List<Object> res = new ArrayList<>();
        for (Object o : l)
            if (s.contains(o))
                res.add(o);
        return res;
    }

    // funzionale, non completa, corretta, semplice, nessuna garanzia sulla lista
    public static <T> List<T> listIntersectionC(List<T> l, Set<? extends T> s) {
        List<T> res = new ArrayList<>();
        for (T o : l)
            if (s.contains(o))
                res.add(o);
        return res;
    }

    // funzionale, completa, corretta, semplice, nessuna garanzia sulla lista, tipo
    // di ritorno utile
    public static <T> List<T> listIntersectionD(List<T> l, Set<?> s) {
        List<T> res = new ArrayList<>();
        for (T o : l)
            if (s.contains(o))
                res.add(o);
        return res;
    }

    // funzionale, completa, corretta, non semplice, nessuna garanzia sulle liste,
    // tipo
    // di ritorno utile
    public static <S, T> List<T> listIntersectionE(List<T> l, Set<S> s) {
        List<T> res = new ArrayList<>();
        for (T o : l)
            if (s.contains(o))
                res.add(o);
        return res;
    }

    // BEST
    public static <T> List<T> listIntersectionF(List<? extends T> l, Set<?> s) {
        List<T> res = new ArrayList<>();
        for (T o : l)
            if (s.contains(o))
                res.add(o);
        return res;
    }
}

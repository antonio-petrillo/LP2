import java.util.*;

public class FindPrevious {

    // non funzionale, il comparatore non puó consumare i valori del set
    // public static <T> T findPreviousA(Set<? extends T> set, Comparator<?> comp, T
    // x) {
    // return null;
    // }

    // funzionale, completa, corretta, no garanzie, inutilmente complicata
    public static <S, T extends S> T findPreviousB(Set<T> set, Comparator<S> comp, T x) {
        T min = null;
        for (T t : set)
            if (min == null && comp.compare(t, x) < 0 || comp.compare(min, t) <= 0 && comp.compare(t, x) < 0)
                min = t;
        return min;
    }

    // non funzionale, il comparatore comp non puó consumare un oggetto di tipo s
    // public static <S, T extends S> S findPreviousC(Set<S> set, Comparator<T>
    // comp, S x) {
    // return null;
    // }

    // funzionale, completa, corretta, semplice, poche garanzie,
    public static <T> T findPreviousD(Set<T> set, Comparator<? super T> comp, T x) {
        T min = null;
        for (T t : set)
            if (min == null && comp.compare(t, x) < 0 || comp.compare(min, t) <= 0 && comp.compare(t, x) < 0)
                min = t;
        return min;
    }

    // funzionale, non completa, corretta, semplice, nessuna garanzia
    public static <T> T findPreviousE(Set<T> set, Comparator<T> comp, T x) {
        T min = null;
        for (T t : set)
            if (min == null && comp.compare(t, x) < 0 || comp.compare(min, t) <= 0 && comp.compare(t, x) < 0)
                min = t;
        return min;
    }

    // non funzionale, dal set posso solo estrarre Object che poi non possono essere
    // utilizzati nel comparator.
    // public static <T> T findPreviousF(Set<? super T> set, Comparator<T> comp, T
    // x) {
    // return null;
    // }

    // BEST, come D ma con piú garanzie
    public static <T> T findPreviousD(Set<? extends T> set, Comparator<? super T> comp, T x) {
        T min = null;
        for (T t : set)
            if (min == null && comp.compare(t, x) < 0 || comp.compare(min, t) <= 0 && comp.compare(t, x) < 0)
                min = t;
        return min;
    }
}

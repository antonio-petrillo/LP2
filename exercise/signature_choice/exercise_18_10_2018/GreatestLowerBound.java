import java.util.*;

public class GreatestLowerBound {

    // funzionale, non completa, corretta, semplice, molte garanzie
    public static <T> T gLBA(Set<? extends T> a, Set<? extends T> b, Comparator<T> c) {
        return null;
    }

    // non funzionale, il comparator di Object é inutile dato che posso passare solo
    // S e T
    // public static <S, T> Object gLBB(Set<S> a, Set<T> b, Comparator<Object> c) {
    // return null;
    // }

    // funzionale, non completa, corretta, semplice, no garanzie
    public static <T> T gLBC(Set<T> a, Set<T> b, Comparator<? super T> c) {
        return null;
    }

    // funzionale, completa, corretta, non semplice, no garanzie
    public static <S, T extends S> S gLBD(Set<S> a, Set<T> b, Comparator<S> c) {
        return null;
    }

    // non funzionale, con ? super posso solo lavorare su Object, ma Object non puó
    // essere utilizzato dal comparatore
    // public static <T> T gLBE(Set<? super T> a, Set<? super T> b, Comparator<T> c)
    // {
    // return null;
    // }

    // BEST

    public static <T> T gLBF(Set<? extends T> a, Set<? extends T> b, Comparator<? super T> c) {
        // T min = GreatestLowerBound.<T>getMin(b, c);
        T min = b.stream().min(c);
        // T max = null;
        // for (T t : a)
        // if (max == null || c.compare(max, t) <= 0 && c.compare(t, min) < 0)
        // max = t;
        // return max;

        return a.stream()
                .filter(t -> c.compare(t, min) < 0)
                .sorted(c.reversed())
                .limit(1)
    }

    private static <T> getMin(Set<? extends T> s, Comparator<? super T> c){
        // T min = null;
        // for(T t: s)
        //    if(min == null || c.compare(min, t) <= 0)
        //        min = t;
        // return min;

        return s.stream()
            .sorted(c)
            .limit(1);
    }
}

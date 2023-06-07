import java.util.*;

public class Agree {
    // funzionale, non completa, corretta, semplice
    public static <T> boolean agreeA(Comparator<T> c1, Comparator<T> c2, T a, T b) {
        return true;
    }

    // funzionale, non completa, corretta, semplice
    public static boolean agreeB(Comparator<Object> c1, Comparator<Object> c2, Object a, Object b) {
        return true;
    }

    // non funzionale, i due comparatori non possono lavorare su a e b
    // public static <S, T> boolean agreeC(Comparator<S> c1, Comparator<T> c2, S a,
    // T
    // b) {
    // return true;
    // }

    // non funzionale ai comparatori posso passare solo null
    // public static <T> boolean agreeD(Comparator<? extends T> c1, Comparator<?
    // extends T> c2, T a, T b) {
    // return true;
    // }

    // BEST
    public static <T> boolean agreeE(Comparator<? super T> c1, Comparator<? super T> c2, T a, T b) {
        return c1.compare(a, b) == c2.compare(a, b);
    }

    // funzionale, completa, corretta, non semlice
    public static <S, T extends S> boolean agreeF(Comparator<S> c1, Comparator<S> c2, T a, T b) {
        return true;
    }
}

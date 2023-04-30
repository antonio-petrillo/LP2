import java.util.*;

public class FindNext {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(42);
        set.add(21);
        set.add(2);
        set.add(18);
        set.add(38);
        set.add(16);
        set.add(20);
        System.out.println(
                "next of 17 is => " + FindNext.<Integer>findNextD(set, Integer::compare, Integer.valueOf(17)));
        System.out.println(
                "next of 17 is => " + FindNext.<Integer>findNextBest(set, Integer::compare, Integer.valueOf(17)));
    }

    // non funzionale, al comparator posso passare solo null
    // public static <T> T findNextA(Set<? extends T> set, Comparator<?> comp, T x)
    // {
    // return null;
    // }

    // non funzionale, se T = manager e S = employee non funziona
    // public static <S, T extends S> T findNextB(Set<T> set, Comparator<S> comp, T
    // x) {
    // return null;
    // }

    // non funzionale, non posso comparare S e T
    // public static <S, T extends S> S findNextC(Set<S> set, Comparator<T> comp, S
    // x) {
    // S result = null;
    // for (S s : set) {
    // if (comp.compare(s, x) > 0) { // questo non lo posso fare
    // if (result == null) {
    // result = s;
    // } else {
    // result = (comp.compare(result, s) >= 0) ? s : result;
    // }
    // }
    // }
    // return result;
    // }

    // la migliore per ora
    public static <T> T findNextD(Set<T> set, Comparator<? super T> comp, T x) {
        T result = null;
        for (T t : set) {
            if (comp.compare(t, x) > 0) {
                if (result == null) {
                    result = t;
                } else {
                    result = (comp.compare(result, t) >= 0) ? t : result;
                }
            }
        }
        return result;
    }

    // non funzionale, x potrebbe non essere comparabile secondo Comparator<T> comp
    // public static <T> T findNextE(Set<T> set, Comparator<T> comp, Object x) {
    // return null;
    // }

    // la migliore possibile
    public static <T> T findNextBest(Set<? extends T> set, Comparator<? super T> comp, T x) {
        T result = null;
        for (T t : set) {
            if (comp.compare(t, x) > 0) {
                if (result == null) {
                    result = t;
                } else {
                    result = (comp.compare(result, t) >= 0) ? t : result;
                }
            }
        }
        return result;
    }

}

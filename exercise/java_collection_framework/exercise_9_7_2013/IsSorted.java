import java.util.*;

public class IsSorted {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        System.out.println("l is sorted? => " + IsSorted.<Integer>isSorted(l, (a, b) -> Integer.compare(a, b)));

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);
        l2.add(4);
        l2.add(5);
        l2.add(4);

        System.out.println("l2 is sorted? => " + IsSorted.<Integer>isSorted(l2, (a, b) -> Integer.compare(a, b)));

    }

    // non funzionale
    // public boolean isSorted(List<?> x, Comparator<Object> c) {
    // return false;
    // }

    // best
    public static <S> boolean isSorted(List<? extends S> x, Comparator<? super S> c) {
        if (x.size() <= 1) {
            return true;
        }
        Iterator<? extends S> iter = x.iterator();
        S prev, curr = iter.next();
        do {
            prev = curr;
            curr = iter.next();
        } while (c.compare(prev, curr) <= 0 && iter.hasNext());
        return !iter.hasNext() && c.compare(prev, curr) <= 0;
    }

    // non funzionale
    // public <S> boolean isSorted(List<S> x, Comparator<S> c) {
    // return false;
    // }

    // funzionale, non completa, non corretta
    // public boolean isSorted(List<Object> x, Comparator<Object> c) {
    // return false;
    // }

    // non funzionale
    // public <S, T> boolean isSorted(List<S> x, Comparator<T> c) {
    // return false;
    // }

    // funzionale, completa, corretta, nessuna garanzia, due parametri di tipo
    // public <S, T extends S> boolean isSorted(List<T> x, Comparator<S> c) {
    // return false;
    // }

}

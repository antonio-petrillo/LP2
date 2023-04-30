import java.util.*;

public class ReverseList {

    public static void main(String[] args) {

        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        System.out.println(l);
        System.out.println(ReverseList.<Integer>reverseListD(l));
        System.out.println(ReverseList.<Integer>reverseListBest(l));

    }

    // non funzionale
    // public static List<?> reverseListA(List<?> l) {
    // return null;
    // }

    // non funzionale
    // public static <T> List<? extends T> reverseListB(List<? super T> l) {
    // return null;
    // }

    // non funzionale, non posso aggiunger nulla nella lista T istanziata per il
    // tipod di ritorono
    // public static <T extends List<?>> T reverseListC(T l) {
    // return null;
    // }

    // funzionale, completa, corretta, nessuna garanzia, il piú semplice possibile
    public static <T> List<T> reverseListD(List<T> l) {
        List<T> r = new ArrayList<>();
        if (l instanceof RandomAccess) {
            for (int i = l.size() - 1; i >= 0; i--) {
                r.add(l.get(i));
            }
        } else {
            ListIterator<T> iter = l.listIterator(l.size());
            while (iter.hasPrevious()) {
                r.add(iter.previous());
            }
        }
        return r;
    }

    // funzionale, non completa, corretta, no garanzie, semplice
    // non la testo nemmeno
    public static List<Object> reverseListE(List<Object> l) {
        List<Object> r = new ArrayList<>();
        if (l instanceof RandomAccess) {
            for (int i = l.size() - 1; i >= 0; i--) {
                r.add(l.get(i));
            }
        } else {
            ListIterator<Object> iter = l.listIterator(l.size());
            while (iter.hasPrevious()) {
                r.add(iter.previous());
            }
        }
        return r;
    }

    // best
    public static <T> List<T> reverseListBest(List<? extends T> l) {
        List<T> r = new ArrayList<>();
        if (l instanceof RandomAccess) {
            for (int i = l.size() - 1; i >= 0; i--) {
                r.add(l.get(i));
            }
        } else {
            ListIterator<? extends T> iter = l.listIterator(l.size());
            while (iter.hasPrevious()) {
                r.add(iter.previous());
            }
        }
        return r;
    }

}

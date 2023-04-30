import java.util.*;

public class Interleave {

    public static void main(String[] args) {
        List<Integer> l1 = List.of(1, 2, 3, 4, 5);
        List<Double> l2 = List.of(1., 2., 3., 4., 5.);
        List<Number> l3 = new ArrayList<>();
        Interleave.<Number>interleave(l1, l2, l3);
        System.out.println(l3);
    }

    public static <T> void interleave(List<? extends T> l1, List<? extends T> l2, List<? super T> l3) {
        Iterator<? extends T> iter2 = l2.iterator();
        for (T t : l1) {
            l3.add(t);
            if (iter2.hasNext()) {
                l3.add(iter2.next());
            }
        }
        while (iter2.hasNext()) {
            l3.add(iter2.next());
        }
    }

    /*
     * a) <S> void interleave(List<S> a, List<S> b, List<S> c)
     * funzionale, non completa, corretta, semplice, nessuna garanzia
     * b) <S, T extends S> void interleave(List<T> a, List<T> b, List<S> c)
     * funzionale, completa, corretta, non semplice, nessuna garanzia
     * c) void interleave (List<?> a, List<?> b, List<Object> c)
     * funzionale, completa, corretta, semplice, tutte le garanzie, List<Object> é
     * un pó inutile per il chiamante
     * d) <S> void interleave(List<?> a, List<?> b, List<S> c)
     * non funzionale, in c posso aggiungere solo S, ma le altre producono Object
     * e) <S> void interleave(List<S> a, List<S> b, List<? super S> c)
     * funzionale, non completa, corretta, non posso leggere c, semplice
     *
     * M)<T> void interleave(List<? extends T>a,List<? extends T>b,List<? superT> c)
     * funzionale, completa, corretta, tutte le garanzie del caso, il piú semplice
     * possibile
     */

}

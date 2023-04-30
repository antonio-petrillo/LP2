import java.util.*;

public class SplitList {

    public static void main(String[] args) {
        List<Integer> src = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();
        SplitList.<Integer>splitList(src, Integer.valueOf(4), p1, p2);
        System.out.println(p1);
        System.out.println(p2);
    }

    public static <T> void splitList(List<? extends T> src, T x, List<? super T> part1, List<? super T> part2) {
        boolean found = false;
        for (T t : src) {
            if (!found && !t.equals(x)) {
                part1.add(t);
            } else if (!found && t.equals(x)) {
                part2.add(t);
                found = true;
            } else {
                part2.add(t);
            }
        }
    }

    // a) <T> void splitList(List<T> src, T x, List<T> part1, List<T> part2)
    // funzionale, non completa, corretta, semplice, nessuna garanzia

    // b) void splitList (List<Object> src, Object x, List<?> part1, List<?> part2)
    // non funzionale, in part1 e part2 posso aggiungere solo null

    // c) <S,T> void splitList(List<S> src, S x, List<T> part1, List<T> part2)
    // non funzionale, nessuna relazionne tra S e T, non posso aggiungere i valori
    // di src nei 2 output

    // d) <T> void splitList(List<? extends T> src, T x, List<T> part1, List<T>
    // part2)
    // funzionale, corretta, completa, semplice, garantisce che non modifico src

    // e) <T> void splitList(List<T> src, Object x, List<? super T> part1, List<?
    // super T> part2)
    // funzionale, corretta, completa, semplice, garantisce che non scrivo su src
    // e che non leggo da part1 e part2
}

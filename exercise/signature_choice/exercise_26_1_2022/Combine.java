import java.util.*;

public class Combine {

    public static void main(String[] args) {
        Comparator<Integer> c1 = (Integer a, Integer b) -> {
            if (a % 2 == 0 && b % 2 == 1)
                return -1;
            else if (a % 2 == 1 && b % 2 == 0)
                return 1;
            else
                return 0;
        };

        Comparator<Integer> c2 = (Integer a, Integer b) -> {
            return Integer.compare(a, b);
        };

        System.out.println("Equal (c1)? => 2, 4 := " + c1.compare(2, 4));
        System.out.println("Equal (c2)? => 2, 4 := " + c2.compare(2, 4));
        System.out.println("Equal (combine)? => 2, 4 := " + (Combine.<Integer>combineA(c1, c2)).compare(2, 4));
        System.out.println("Equal (combine)? => 2, 4 := " + (Combine.<Integer>combineD(c1, c2)).compare(2, 4));
    }

    // funzionale, non completa, corretta, nessuna garanzia extra (ma comunque
    // Comparator é un'interfaccia funzionale), semplicitá ridotta all'osso.
    public static <T> Comparator<T> combineA(Comparator<T> a, Comparator<T> b) {
        return new Comparator<T>() {

            @Override
            public int compare(T x, T y) {
                int first = a.compare(x, y);
                return first != 0 ? first : b.compare(x, y);
            }

        };
    }

    // non funzionale, al secondo comparator posso passare solo null
    // public static <T> Comparator<T> combineB(Comparator<T> a, Comparator<?> b) {
    // return null;
    // }

    // non funzionale, restituendo Comparator<S> implica che => Comparator<S> c
    // viene usato nel seguente modo:
    // c.(s1, s2) che internamente diviene :
    // a.compare(s1, s2) e poi b.compare(s1, s2) ma questi metodi non lo accettano
    // public static <S, T extends S, U extends S> Comparator<S>
    // combineC(Comparator<T> a, Comparator<U> b) {
    // return null;
    // }

    // candidate, la migliore finora
    // funzionale, completa, corretta, garanzie
    // il piú semplice possibile
    public static <T> Comparator<T> combineD(Comparator<? super T> a, Comparator<? super T> b) {
        return (T x, T y) -> {
            int first = a.compare(x, y);
            return first != 0 ? first : b.compare(x, y);
        };
    }

    // non funzionale, nessuna relazione tra T e Object
    // public static <T> Comparator<T> combineE(Comparator<Object> a,
    // Comparator<Object> b) {
    // return null;
    // }

    // non funzionale, il parametro di ritorno impone che il comparatore restituito
    // accetta solo null;
    // public static <T> Comparator<? extends T> combineF(Comparator<? super T> a,
    // Comparator<? super T> b) {
    // return null;
    // }

}

import java.util.*;

public class ExtractPos {

    public static void main(String[] args) {
        List<Integer> l = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        System.out.println(ExtractPos.<Integer>extractPosB(l, 4));
        System.out.println(ExtractPos.<Integer>extractPosC(l, 4));
        System.out.println(ExtractPos.<Integer>extractPosD(l, 4));
    }

    // a) Object extractPos(Collection<?> l, int n)
    // non funzionale, l potrebbe non essere una lista
    public static <T> T extractPosB(List<T> l, int n) {
        // funzionale, completa, corretta, nessuna garanzia, il piú semplice possibile
        if (l.size() < n) {
            return null;
        }
        T res = null;
        int counter = 0;
        for (T t : l) {
            if (counter == n) {
                res = t;
                break;
            }
            counter++;
        }
        return res;
    }

    public static <T> T extractPosC(List<? extends T> l, int n) {
        // funzionale, completa, corretta, non posso modifcare l, il piú semplice
        // possibile
        if (l.size() < n) {
            return null;
        }
        T res = null;
        int counter = 0;
        for (T t : l) {
            if (counter == n) {
                res = t;
                break;
            }
            counter++;
        }
        return res;
    }

    public static Object extractPosD(List<?> l, int n) {
         // funzionale, completa, corretta, non posso modifcare l, il piú semplic
        //  possibile anche troppo.
        // il tipo di ritorno é poco utile al chiamante
        if (l.size() < n) {
            return null;
        }
        Object res = null;
        int counter = 0;
        for (Object o : l) {
            if (counter == n) {
                res = o;
                break;
            }
            counter++;
        }
        return res;
    }

    // <T> T extractPos(LinkedList<T> l, int n)
    // identica a B

    // <S,T> S extractPos(List<T> l, int n)
    // inutilmente complicata

}

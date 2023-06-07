import java.util.*;

public class InverseMap {

    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap<>();
        m.put(1, "pujaz");
        m.put(2, "papapujaz");
        m.put(3, "sucuzzone");

        printMap(m);
        printMap(inverseMapB(m));
        printMap(inverseMapC(m));
        printMap(inverseMapF(m));

        m.put(4, "pujaz");
        printMap(inverseMapF(m));
    }

    // Non Funzionale, posso solo inserire obj, quindi devo fare una Map<Obj, Obj>
    // che non é comp con Map<K, V>
    // public static <K, V> Map<V, K> inverseMapA(Map<?, ?> m) {
    // return null;
    // }

    // Funzionale, compleata, corretta, non modifico m, molto semplice, inutile per
    // il chiamante
    public static Map<?, ?> inverseMapB(Map<?, ?> m) {
        Map<Object, Object> res = new HashMap<>();
        for (Object k : m.keySet()) {
            Object v = m.get(k);
            if (res.containsKey(v)) {
                throw new IllegalArgumentException("duplicate keys");
            }
            res.put(v, k);
        }
        return res;
    }

    // Funzionale, completa, corretta, non fornisce ulteriori garanzie, il piú
    // semplice possibile per far in modo che al chiamante possa essere utile.
    public static <K, V> Map<K, V> inverseMapC(Map<V, K> m) {
        Map<K, V> res = new HashMap<>();
        for (V v : m.keySet()) {
            K k = m.get(v);
            if (res.containsKey(k)) {
                throw new IllegalArgumentException("duplicate keys");
            }
            res.put(k, v);
        }
        return res;
    }

    // Non Funzionale, il vincolo ? super K impone che quello che ottengo dalla mapp
    // possa essere al piú K on una sua sottoclasse, nulla impedisca che sia ad
    // esempio Object
    // public static <K, V> Map<K, V> inverseMapD(Map<? extends V, ? super K> m) {
    // }

    // Non Funzionale, non posso invertire una mappa se il tipo di ritorno mi
    // impedisce di cambiare i parametri della mappa.
    // public static <K, V> Map<K, V> inverseMapE(Map<K, V> m) {
    // return null;
    // }

    // la migliore
    // Funzionale, completa, corretta, non modifico la mappa in input in nessun
    // modo, il piú semplice possibile per le funzionaalitá richieste.
    public static <K, V> Map<K, V> inverseMapF(Map<? extends V, ? extends K> m) {
        Map<K, V> res = new HashMap<>();
        for (V v : m.keySet()) {
            K k = m.get(v);
            if (res.containsKey(k)) {
                throw new IllegalArgumentException("duplicate keys");
            }
            res.put(k, v);
        }
        return res;
    }

    public static void printMap(Map<?, ?> m) {
        System.out.println("Begin print map:");
        for (Object o : m.keySet()) {
            System.out.println("Key := " + o + ", Value := " + m.get(o));
        }
        System.out.println("End print map\n");
    }

}

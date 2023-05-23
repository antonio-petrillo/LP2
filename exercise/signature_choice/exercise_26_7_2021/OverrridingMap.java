import java.util.*;

public class OverrridingMap {

    public static void main(String[] args) {

        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();

        m1.put("ciao", 1);
        m1.put("mondo", 2);

        m2.put("ciao", 3);
        m2.put("sucuzzone", 4);

        System.out.println(OverrridingMap.<String, Integer>overridingMapD(m1, m2));

    }

    // funzionale, non completa, corretta, non semplice, nessuna garanzia ed il tipo
    // di ritorno é inutile
    // public static <K, V> Map<?, ?> overridingMapA(Map<K, V> map1, Map<K, V> map2)
    // {
    // return null;
    // }

    // funzionale, non completa, corretta, non posso modificare le chiavi, il tipo
    // di ritorno é migliore di A ma non é comunque ottimale
    // public static <K> Map<K, ?> overridingMapB(Map<K, ?> map1, Map<K, ?> map2) {
    // return null;
    // }

    // non funzionale, se una chiave compare anche nella seconda mappa non posso
    // aggiungerlo al risultato
    // public static <K, V> Map<K, V> overridingMapC(Map<K, V> map1, Map<? extends
    // K, ?> map2) {
    // return null;
    // }

    // funzionale, completa, corretta, semplice, tipo di ritorno utile
    // é la migliore firma
    public static <K, V> Map<K, V> overridingMapD(Map<K, ? extends V> map1, Map<?, ? extends V> map2) {
        Map<K, V> result = new HashMap<>();
        for (K k : map1.keySet()) {
            if (map2.containsKey(k)) {
                result.put(k, map2.get(k));
            } else {
                result.put(k, map1.get(k));
            }
        }
        return result;
    }

    // non funzionale, dato che le chiavi sono definite come ? super K nel momento
    // in cui le estraggo posso solo assegnarle ad Object,
    // questo implica che non posso aggiungerle alla mappa restituita (quest'ultima
    // é definita ? extends K)
    // public static <K, V> Map<? extends K, V> overridingMapE(Map<? super K, V>
    // map1, Map<? super K, V> map2) {
    // return null;
    // }

    // funzionale, non completa, corretta, semplice, l'unica garanzia é che non
    // modifico le chiavi della seconda mappa
    // public static <K> Map<K, Object> overridingMapF(Map<K, Object> map1, Map<?,
    // Object> map2) {
    // return null;
    // }

}

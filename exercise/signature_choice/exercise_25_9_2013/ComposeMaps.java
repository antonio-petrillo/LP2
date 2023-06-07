import java.util.*;

public class ComposeMaps {
    // funzionale, non completa, corretta, non semplice, no garanzie
    public static <S, T, U> Map<S, U> composeMapsA(Map<S, T> a, Map<T, U> b) {
        return null;
    }

    // funzionale, completa, corretta, non semplice, no garanzie su a e poche su b
    public static <S, T, U> Map<S, U> composeMapsB(Map<S, T> a, Map<? extends T, U> b) {
        return null;
    }

    // funzionale, completa, corretta, non semplice, no garanzie su a e poche su b.
    // per quanto riguarda la completezza va osservato che la seconda mappa b deve
    // consumare Object quinti il ? super
    // é superfluo (il parametro T é superfluo)
    public static <S, T, U> Map<S, U> composeMapsC(Map<S, T> a, Map<? super T, U> b) {
        return null;
    }

    // funzionale, completa, corretta, semplice, poche garanzie su a e b; (BEST)
    public static <S, U> Map<S, U> composeMapsD(Map<S, ?> a, Map<?, U> b) {
        return null;
    }

    // funzionale, non completa, corretta, semplice, poche garanzie
    public static <S, U> Map<S, U> composeMapsE(Map<S, Object> a, Map<Object, U> b) {
        return null;
    }

    // BEST
    public static <S, U> Map<S, U> composeMapsF(Map<? extends S, ?> a, Map<?, ? extends U> b) {
        Map<S, U> composed = new HashMap<>();
        for (S s : a.keySet()) {
            if (b.containsKey(s)) {
                composed.put(s, b.get(s));
            }
        }
        return composed;
    }

}

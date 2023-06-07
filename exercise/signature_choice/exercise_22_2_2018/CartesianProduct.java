import java.util.*;

public class CartesianProduct {

    // funzionale, non completa, corretta, no garanzie, semplice
    public static <S, T> Set<Pair<S, T>> cartesianProductA(Set<S> s, Set<T> t) {
        Set<Pair<S, T>> prod = new HashSet<>();
        for (S ss : s)
            for (T tt : t)
                prod.add(new Pair<>(ss, tt));
        return prod;
    }

    // non funzionale, da s e t posso estrarre solo object che peró non é
    // utilizzabile per produrre il risultato richiesto
    // public static <S, T> Set<Pair<S, T>> cartesianProductB(Set<?> s, Set<?> t) {
    // return null;
    // }

    // funzionale, non completa, corretta, semplice, no garanzie, tipo di ritorno
    // poco utile.
    public static Set<Pair<?, ?>> cartesianProductC(Set<Object> s, Set<Object> t) {
        Set<Pair<Object, Object>> prod = new HashSet<>();
        for (Object ss : s)
            for (Object tt : t)
                prod.add(new Pair<>(ss, tt));
        return prod;
    }

    // non funzionale, l'oggetto di ritorno non puó essere utilizzato come un Pair,
    // quindi non avendo coppie non posso realizzare il prodotto cartesiano
    // In realtá internamente il set puó davvero rappresentare un prodotto
    // cartesiano, ma il chiamante non potrá mai utilizzarlo
    // public static <S, T> Set<?> cartesianProductD(Set<S> s, Set<T> t) {
    // return null;
    // }

    // funzionale, non completa, corretta, semplice anche troppo, no garanzie
    public static <S> Set<Pair<S, S>> cartesianProductE(Set<S> s, Set<S> t) {
        Set<Pair<S, S>> prod = new HashSet<>();
        for (S ss : s)
            for (S tt : t)
                prod.add(new Pair<>(ss, tt));
        return prod;
    }

    // funzionale, completa, corretta, non semplic no garanzie
    public static <S, T extends S> Set<Pair<S, T>> cartesianProductF(Set<S> s, Set<T> t) {
        Set<Pair<S, T>> prod = new HashSet<>();
        for (S ss : s)
            for (T tt : t)
                prod.add(new Pair<>(ss, tt));
        return prod;
    }

    // BEST
    public static <S, T extends S> Set<Pair<S, T>> cartesianProductG(Set<? extends S> s, Set<? extends T> t) {
        Set<Pair<S, T>> prod = new HashSet<>();
        for (S ss : s)
            for (T tt : t)
                prod.add(new Pair<>(ss, tt));
        return prod;
    }
}

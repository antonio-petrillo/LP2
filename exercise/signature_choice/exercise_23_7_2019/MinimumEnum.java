public class MinimumEnum {

    // funzionale, completa, corretta, semplice, tipo di ritorno inutile
    public static Enum<?> minA(Enum<?> a, Enum<?> b) {
        if (a.getClass() != b.getClass())
            return null;
        return a.ordinal() < b.ordinal() ? a : b;
    }

    // non funzionale
    // public static <T> Enum<T> minB(Enum<T> a, Enum<T> b) {
    // }

    // funzionale, non completa, corretta, tipo di ritorno utile.
    public static <S extends Enum<S>> S minC(S a, S b) {
        return a.ordinal() < b.ordinal() ? a : b;
    }

    // funzionale, completa, corretta, semplice, genera un warning
    public static <S extends Enum<S>> S minD(S a, Object b) {
        if (a.getClass() != b.getClass())
            return null;
        S be = (S) b;
        return a.ordinal() < be.ordinal() ? a : be;
    }

    // non funzionale
    // public static <T> Enum<T> minE(Enum<T> a, Enum<?> b) {
    // }
}

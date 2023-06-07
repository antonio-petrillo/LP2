public class Pair<S, T> {
    private S first;
    private T second;

    public Pair(S s, T t) {
        first = s;
        second = t;
    }

    public void setFirst(S s) {
        first = s;
    }

    public void setSecond(T t) {
        second = t;
    }

    public S getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}

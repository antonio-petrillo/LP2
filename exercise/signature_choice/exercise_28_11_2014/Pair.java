public class Pair<S, T> {

    private S s;
    private T t;

    public Pair(S s, T t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("value in a pair cannot be null");
        }
        this.s = s;
        this.t = t;
    }

    @Override
    public String toString() {
        return "<" + s.toString() + ", " + t.toString() + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != getClass()) {
            return false;
        }
        Pair<S, T> p = (Pair<S, T>) o;
        return s.equals(p.s) && p.equals(p.t);
    }

}

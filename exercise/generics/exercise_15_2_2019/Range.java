import java.util.*;

public class Range<T extends Comparable<? super T>> {

    private T low, high;

    public Range(T low, T high) {
        this.low = low;
        this.high = high;
    }

    public boolean isInside(T x) {
        return x.compareTo(low) >= 0 && x.compareTo(high) <= 0;
    }

    public boolean isOverlapping(Range<T> r) {
        return isInside(r.low) || isInside(r.high);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Range))
            return false;
        Range<T> r = (Range<T>) o;
        return low == r.low && high == r.high;
    }

    @Override
    public int hashCode() {
        return low.hashCode() ^ high.hashCode();
    }

    public static void main(String[] args) {
        Range<Integer> a = new Range<>(10, 20);
        System.out.println(a.isInside(10));
        System.out.println(a.isInside(50));
        Range<String> b = new Range<>("albero", "dirupo");
        Range<String> c = new Range<>("casa", "catrame");
        System.out.println(b.isOverlapping(c));
        // Range<Object> d = new Range<>(); // errore di compilazione
    }

}

import java.util.*;

public class A {
    Comparator<Double> b = new B(null);
    Comparator<String> c = (x, y) -> B.g(x, y);

    // <T> A f(T x, T y) { // this may be a refuse, A must be B
    <T> B f(T x, T y) {
        return new B(x == y);
    }
}

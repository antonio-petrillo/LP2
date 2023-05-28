import java.util.*;

public class A {
    public interface Convertible<T> {
        public T convert();
    }

    private Convertible<A> x = new B();
    private Iterable<A> y = new B(3);

    private Iterable<A> z = B.g(x); // impossible to satisfy
    private Iterable<? extends B> t = B.g(B.b); // impossible to satisfy
}

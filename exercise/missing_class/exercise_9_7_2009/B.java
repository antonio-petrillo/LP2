import java.util.*;

public class B extends A implements A.Convertible<A>, Iterable<A> {
    public static final A.Convertible<B> b = null;

    public B() {
    }

    public B(int n) {
    }

    @Override
    public A convert() {
        return new A();
    }

    @Override
    public Iterator<A> iterator() {
        return null;
    }

    public static Iterable<A> g(A.Convertible<? extends A> c) {
        return null;
    }

}

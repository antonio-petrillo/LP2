import java.util.*;

public class A {
    private B<Integer> b1 = new B<Integer>(null);
    private B<?> b2 = B.f(3);
    private Comparable<? extends Number> c = new B<Double>();

    public Object f() {
        Integer x = b1.getIt();
        Integer y = x + b2.getIt();
        return new B<String>(new A());
    }
}

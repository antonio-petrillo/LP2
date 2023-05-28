import java.util.*;

public class B<T> {

    public B() {
    }

    public B(T t) {

    }

    public Cloneable g1() {
        return null;
    }

    public B<String> g2(T t) {
        return new B<String>(t.toString());
    }

    public Number f(Object o) {
        return null;
    }

    public int compareTo(Object o) {
        return 0;
    }

}

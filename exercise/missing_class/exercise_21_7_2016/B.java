import java.util.*;

public class B<T> implements Iterable<Integer> {

    public B() {
    }

    public B(Object o) {

    }

    public Iterator<Integer> iterator() {
        return null;
    }

    public static <V> String buildMessage(V v) {
        return v.toString();
    }

    public boolean check(Set<?> s, Object o) {
        return true;
    }

    public Set<Number> process(Set<?> s1, Set<?> s2, Object o) {
        return null;
    }

}

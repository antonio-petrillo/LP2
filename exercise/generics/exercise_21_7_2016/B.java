import java.util.*;

public class B<T> implements Iterable<Integer> {
    private T t;

    public B() {
    }

    public B(T t) {
        this.t = t;
    }

    public static <K> String buildMessage(K k) {
        return k.toString();
    }

    public boolean check(Set<Integer> s1, Integer n) {
        return false;
    }

    public Set<? super Number> process(Set<?> s1, Set<?> s2, Integer n) {
        return null;
    }

    public Iterator<Integer> iterator() {
        return null;
    }

}

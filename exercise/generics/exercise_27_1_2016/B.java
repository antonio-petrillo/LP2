import java.util.*;

public class B<T> {

    public static void process(Collection<?> c1, Collection<?> c2) {

    }

    public T select(Collection<? extends T> c) {
        return null;
    }

    public HashSet<T> filter(Set<? extends T> c) {
        return null;
    }

}

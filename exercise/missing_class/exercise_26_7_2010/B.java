import java.util.*;

public class B<T> implements Comparable<T> {

    public B() {
    }

    public B(Object o) {
    }

    public static B<?> f(int i) {
        return null;
    }

    public int getIt() {
        return 0;
    }

    @Override
    public int compareTo(T other) {
        return 0;
    }

}

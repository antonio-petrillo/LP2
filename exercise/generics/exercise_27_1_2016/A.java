import java.util.*;

public class A {
    public static <S, T extends S> void f(Set<S> set1, Set<T> set2) {
        B.process(set1, set2);
        B.process(set2, set1);
        B<S> b = new B<S>();
        S choice1 = b.select(set1);
        S choice2 = b.select(set2);
        Collection<? extends S> c = b.filter(set1);
        HashSet<? super S> hs = b.filter(set1);
    }
}

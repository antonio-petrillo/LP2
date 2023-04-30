import java.util.*;

public class Product {

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s2.add("ciao");
        s2.add("pujaz");
        System.out.println(Product.<Integer, String>product(s1, s2));
    }

    public static <S, T> Set<Pair<S, T>> product(Set<? extends S> s1, Set<? extends T> s2) {
        Set<Pair<S, T>> prod = new HashSet<>();
        for (S s : s1) {
            for (T t : s2) {
                prod.add(new Pair<S, T>(s, t));
            }
        }
        return prod;
    }

}

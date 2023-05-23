import java.util.*;

public class Split {

    public static void main(String[] args) {
        Collection<Integer> a = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Collection<Integer> b = new LinkedList<>();
        Collection<Integer> c = new LinkedList<>();

        Split.<Integer>split(a, b, c);

        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("C: " + c);
    }

    public static <T> void split(Collection<? extends T> a, Collection<? super T> b, Collection<? super T> c) {
        int counter = 0;
        for (T t : a) {
            if (counter < a.size() >> 1) {
                b.add(t);
            } else {
                c.add(t);
            }
            counter++;
        }
    }

}

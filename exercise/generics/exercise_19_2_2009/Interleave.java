import java.util.*;

public class Interleave {

    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<>();
        LinkedList<String> b = new LinkedList<>();
        LinkedList<String> c = new LinkedList<>();

        a.add("a 1");
        a.add("a 2");
        a.add("a 3");

        b.add("b 1");
        b.add("b 2");
        b.add("b 3");
        b.add("b 4");

        Interleave.<String>interleave(a, b, c);
        System.out.println(c);

    }

    public static <T> void interleave(List<? extends T> a, List<? extends T> b, List<? super T> c) {
        Iterator<? extends T> iterA = a.iterator();
        Iterator<? extends T> iterB = b.iterator();
        while (iterA.hasNext() && iterB.hasNext()) {
            c.add(iterA.next());
            c.add(iterB.next());
        }
    }

}

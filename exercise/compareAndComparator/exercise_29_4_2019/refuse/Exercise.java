import java.util.*;
import java.util.function.*;

public class Exercise {

    public static void main(String[] args) {
        Predicate<Integer> a = intNum -> intNum % 2 == 0;
        Predicate<String> b = str -> str.equals("exit");
        Predicate<SortedSet<Integer>> c = set -> set.first() < 0 && set.last() >= 0;
        Predicate<Collection<Object>> d = coll -> coll.stream().distinct().count() == coll.size();

        System.out.println(a.test(2) + "\t" + a.test(1));
        System.out.println(b.test("ciao") + "\t" + b.test("exit"));
        SortedSet<Integer> s1 = new TreeSet<>();
        s1.add(-1);
        s1.add(1);
        SortedSet<Integer> s2 = new TreeSet<>();
        s2.add(-1);
        s2.add(-2);
        System.out.println(c.test(s1) + "\t" + c.test(s2));

        List<Object> l1 = new LinkedList<>();
        l1.add("Ciao");
        l1.add("Ciao");
        l1.add(new Object());
        l1.add(Integer.valueOf(2));
        List<Object> l2 = new LinkedList<>();
        l2.add("Ciao");
        l2.add(new Object());
        l2.add(Integer.valueOf(2));
        List<Object> l3 = new LinkedList<>();
        l3.add("Ciao");
        l3.add(new Object());
        l3.add(new Object());
        l3.add(Integer.valueOf(2));

        System.out.println(d.test(l1) + "\t" + d.test(l2) + "\t" + d.test(l3));

    }
}

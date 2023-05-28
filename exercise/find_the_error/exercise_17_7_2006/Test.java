
// missing import
import java.util.*;

public class Test {
    Collection<?> c; // this not private nor final, it is not an error but it is strange

    public int f(Collection<? extends Number> c) {
        return c.size();
    }

    public void g(Set<? extends Number> c) {
        this.c = c;
    }

    private <T extends Number> T myAdd(T x) {
        c.add(x); // can add only null to c.
        return x;
    }

    public static void main(String args[]) {
        Test t = new Test();

        t.f(new LinkedList<Integer>());
        t.g(new ArrayList<Integer>()); // g require a set not a list
        t.myAdd(new Double(2.0)); // this method is parametric
                                  // maybe the type inference can guest correctly but who knows
    }
}

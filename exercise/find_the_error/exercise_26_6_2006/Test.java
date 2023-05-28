// missing import

// class Test {// missing public
public class Test {// missing public
    public static void f(List<? extends Number> l) {
        l.add(new Integer(3)); // can add only null
    }

    // could be written better, but it is correct
    public static <T> T myGet(Map<T, ? extends T> m, T x) {
        return m.get(x);
    }

    public static void main(String args[]) {
        f(new LinkedList<Integer>());
        f(new ArrayList<Boolean>());
        f(new List<Double>()); // List is abstract
        Object o = myGet(new HashMap<Number, Integer>(), new Integer(7));
        // myGet is parametric
    }
}

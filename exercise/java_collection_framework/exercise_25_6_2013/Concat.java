import java.util.*;

public class Concat {

    public static void main(String[] args) {
        List<String> l1 = new LinkedList<>();
        l1.add("pujaz");
        l1.add("papapujaz");
        l1.add("sucuzzone");
        List<Integer> l2 = new LinkedList<>();
        l2.add(5);
        l2.add(25);
        l2.add(50);
        List<Double> l3 = new LinkedList<>();
        l3.add(5.0);
        l3.add(25.0);
        l3.add(50.0);
        Iterator<Number> iter = concatD(l2.iterator(), l3.iterator());
        System.out.print("[ ");
        while (iter.hasNext()) {
            Number n = iter.next();
            System.out.print(n + " ");
        }
        System.out.println("]");

        Iterator<?> iter2 = concatB(l1.iterator(), l3.iterator());
        System.out.print("[ ");
        while (iter2.hasNext()) {
            Object o = iter2.next();
            System.out.print(o + " ");
        }
        System.out.println("]");
        // I will say that the version D is more useful for the callee, but
        // the version B is complete.
    }

    public static Iterator<?> concatB(Iterator<?> a, Iterator<?> b) {
        return new Iterator<>() {
            Iterator<?> first = a;
            Iterator<?> second = b;

            @Override
            public boolean hasNext() {
                return first.hasNext() || second.hasNext();
            }

            @Override
            public Object next() {
                if (!first.hasNext()) {
                    if (second.hasNext()) {
                        return second.next();
                    } else {
                        throw new NoSuchElementException();
                    }
                } else {
                    return first.next();
                }
            }
        };
    }

    public static <T> Iterator<T> concatD(Iterator<? extends T> a, Iterator<? extends T> b) {
        return new Iterator<T>() {
            Iterator<? extends T> first = a;
            Iterator<? extends T> second = b;

            @Override
            public boolean hasNext() {
                return first.hasNext() || second.hasNext();
            }

            public T next() {
                if (!first.hasNext()) {
                    if (second.hasNext()) {
                        return second.next();
                    } else {
                        throw new NoSuchElementException();
                    }
                } else {
                    return first.next();
                }
            }
        };
    }

}

import java.util.*;

public class SelectorIterator<T> implements Iterable<T> {

    private Collection<? extends T> c;
    private Selector<? super T> s;

    public SelectorIterator(Collection<? extends T> c, Selector<? super T> s) {
        this.c = c;
        this.s = s;
    }

    public Iterator<T> iterator() {

        int step = 0;
        int count = 0;
        for (T t : c) {
            step++;
            if (s.select(t)) {
                count = step;
            }
        }

        final int max = count;

        return new Iterator<>() {

            Iterator<? extends T> originalIterator = c.iterator();
            int step = 0;
            int maxStep = max;

            @Override
            public boolean hasNext() {
                return originalIterator.hasNext() && step < maxStep;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T res = null;
                while (originalIterator.hasNext()) {
                    res = originalIterator.next();
                    if (s.select(res)) {
                        break;
                    }
                }
                return res;
            }

        };
    }

    public static void main(String[] args) {
        Integer[] a = { 1, 2, 45, 56, 343, 22, 12, 7, 56 };
        List<Integer> l = Arrays.asList(a);
        Selector<Integer> pari = new Selector<Integer>() {
            public boolean select(Integer n) {
                return (n % 2) == 0;
            }
        };

        for (Integer n : new SelectorIterator<Integer>(l, pari))
            System.out.print(n + " ");
        System.out.println("");
        for (Integer n : new SelectorIterator<Integer>(l, (n) -> n % 2 == 0))
            System.out.print(n + " ");
        System.out.println("");
    }

}

@FunctionalInterface
interface Selector<T> {
    boolean select(T t);
}

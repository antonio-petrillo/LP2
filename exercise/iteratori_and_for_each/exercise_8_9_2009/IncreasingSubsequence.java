import java.util.*;

public class IncreasingSubsequence<T extends Comparable<? super T>> implements Iterable<T> {

    private List<? extends T> l;

    public IncreasingSubsequence(List<? extends T> l) {
        this.l = l;
    }

    @Override
    public Iterator<T> iterator() {
        int count = 0;
        T max = null;
        int index = 0;
        for (T t : l) {
            index++;
            if (max == null || t.compareTo(max) >= 0) {
                max = t;
                count = index;
            }
        }

        final int maxStep = count;

        return new Iterator<>() {
            Iterator<? extends T> originalIterator = l.iterator();
            int step;
            T curr;

            @Override
            public boolean hasNext() {
                return originalIterator.hasNext() && step < maxStep;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (step == 0) {
                    curr = originalIterator.next();
                    step = 1;
                    return curr;
                }

                T tmp = curr;
                while (originalIterator.hasNext()) {
                    step++;
                    curr = originalIterator.next();
                    if (curr.compareTo(tmp) >= 0) {
                        break;
                    }
                }
                return curr;
            }

        };

    }

    public static void main(String[] args) {
        List<Integer> l = new LinkedList<Integer>();
        l.add(10);
        l.add(3);
        l.add(5);
        l.add(12);
        l.add(11);
        l.add(35);
        for (Integer i : new IncreasingSubsequence<Integer>(l))
            System.out.println(i);
    }

}

import java.util.*;

public class DelayIterator {

    public static void main(String[] args) {
        List<Integer> l = List.of(1, 2, 3, 4, 5, 6, 7);
        Iterator<Integer> i = DelayIterator.<Integer>delayIterator(l.iterator(), 2);
        while (i.hasNext()) {
            System.out.print(i.next() + ", ");
        }
    }

    public static <T> Iterator<T> delayIterator(Iterator<T> iter, int n) {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                try {
                    Thread.sleep(n * 1000);
                } catch (InterruptedException ie) {
                }
                return iter.next();
            }

            @Override
            public void remove() {
                iter.remove();
            }

        };
    }

}

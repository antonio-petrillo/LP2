import java.util.*;

public class MyFor implements Iterable<Integer> {

    private int low, high, increment;

    public static void main(String[] args) {
        for (Integer i : new MyFor(0, 10, 1)) {
            System.out.println(i);
        }
    }

    public MyFor(int low, int high, int increment) {
        this.low = low;
        this.high = high;
        this.increment = increment;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            Integer curr = low;

            @Override
            public boolean hasNext() {
                return curr < high;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Integer res = curr;
                curr += increment;
                return res;
            }

        };
    }

}

import java.util.*;

public class Accumulator<T extends Number> {

    private List<T> positives = new ArrayList<>();
    private List<T> negatives = new ArrayList<>();
    private double sum = 0.;

    public boolean add(T t) {
        sum += t.doubleValue();
        if (t.doubleValue() < 0) {
            return negatives.add(t);
        } else {
            return positives.add(t);
        }
    }

    public double sum() {
        return sum;
    }

    public Iterable<T> positives() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return positives.iterator();
            }
        };
    }

    public Iterable<T> negatives() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return negatives.iterator();
            }
        };
        // return () -> positives.iterator();
    }

    public static void main(String[] args) {
        Accumulator<Integer> acc1 = new Accumulator<>();
        acc1.add(10);
        acc1.add(42);
        acc1.add(-5);
        acc1.add(10);
        for (Integer n : acc1.positives())
            System.out.println(n);
        for (Integer n : acc1.negatives())
            System.out.println(n);
        Accumulator<Double> acc2 = new Accumulator<>();
        acc2.add(-10.0);
        acc2.add(42.0);
        System.out.println(acc2.sum());
    }

}

import java.util.*;
import java.util.function.Predicate;

public class ConcurrentFilter {

    public static void main(String[] args) {
        Set<Integer> x = new HashSet<Integer>();
        x.add(1);
        x.add(2);
        x.add(5);
        Predicate<Integer> oddSelector = (i -> i % 2 != 0);
        Set<Integer> y = concurrentFilter(x, oddSelector);
        for (Integer n : y)
            System.out.println(n);
    }

    public static <T> Set<T> concurrentFilter(Set<? extends T> s, Predicate<? super T> p) {
        List<Thread> threads = new ArrayList<>();
        Set<T> result = new HashSet<>();
        for (T t : s) {
            Thread thread = new Thread(() -> {
                if (p.test(t)) {
                    synchronized (result) {
                        result.add(t);
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                throw new RuntimeException();
            }
        }
        return result;
    }

}

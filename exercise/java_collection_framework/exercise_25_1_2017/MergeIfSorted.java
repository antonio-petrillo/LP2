import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class MergeIfSorted {

    public static <T> List<T> mergeIfSorted(List<? extends T> l1, List<? extends T> l2, Comparator<? super T> c) {
        BlockingQueue<Boolean> q = new ArrayBlockingQueue<>(2);
        Thread t1 = new Thread(() -> {
            T prev = null;
            for (T t : l1) {
                if (prev == null) {
                    prev = t;
                    continue;
                }
                if (c.compare(prev, t) > 0) {
                    try {
                        q.put(false);
                        return;
                    } catch (InterruptedException ie) {
                        return;
                    }
                    return;
                }
                prev = t;
            }
            q.put(true);
        });
        Thread t2 = new Thread(() -> {
            T prev = null;
            for (T t : l2) {
                if (prev == null) {
                    prev = t;
                    continue;
                }
                if (c.compare(prev, t) > 0) {
                    try {
                        q.put(false);
                        return;
                    } catch (InterruptedException ie) {
                        return;
                    }
                }
                prev = t;
            }
            q.put(true);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        try {
            if (!(q.take() && q.take())) {
                return null;
            }
        } catch (InterruptedException ie) {
            return null;
        }
        List<T> result = new ArrayList<>();
        Iterator<? extends T> iter1 = l1.iterator();
        Iterator<? extends T> iter2 = l2.iterator();
        T val1 = null, val2 = null;
        if (iter1.hasNext()) {
            val1 = iter1.next();
        }
        if (iter2.hasNext()) {
            val2 = iter2.next();
        }
        while (iter1.hasNext() && iter2.hasNext()) {
            if (c.compare(val1, val2) <= 0) {
                result.add(val1);
                val1 = iter1.next();
            } else {
                result.add(val2);
                val2 = iter2.next();
            }
        }
        while (iter1.hasNext()) {
            result.add(iter1.next());
        }
        while (iter2.hasNext()) {
            result.add(iter2.next());
        }
        return result;
    }

    public static <T> List<T> mergeIfSortedV2(List<? extends T> l1, List<? extends T> l2, Comparator<? super T> c) {
        boolean[] areSorted = { false, false };
        Thread t1 = new Thread(() -> {
            T prev = null;
            for (T t : l1) {
                if (prev == null) {
                    prev = t;
                    continue;
                }
                if (c.compare(prev, t) > 0) {
                    return;
                }
                prev = t;
            }
            areSorted[0] = true;
        });
        Thread t2 = new Thread(() -> {
            T prev = null;
            for (T t : l2) {
                if (prev == null) {
                    prev = t;
                    continue;
                }
                if (c.compare(prev, t) > 0) {
                    return;
                }
                prev = t;
            }
            areSorted[1] = true;
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        List<T> result = null;
        if (areSorted[0] && areSorted[1]) {
            result = new ArrayList<>();
            Iterator<? extends T> iter1 = l1.iterator();
            Iterator<? extends T> iter2 = l2.iterator();
            T val1 = null, val2 = null;
            if (iter1.hasNext()) {
                val1 = iter1.next();
            }
            if (iter2.hasNext()) {
                val2 = iter2.next();
            }
            while (iter1.hasNext() && iter2.hasNext()) {
                if (c.compare(val1, val2) <= 0) {
                    result.add(val1);
                    val1 = iter1.next();
                } else {
                    result.add(val2);
                    val2 = iter2.next();
                }
            }
            while (iter1.hasNext()) {
                result.add(iter1.next());
            }
            while (iter2.hasNext()) {
                result.add(iter2.next());
            }
        }
        return result;
    }

    public static <T> List<T> mergeIfSortedV3(List<? extends T> l1, List<? extends T> l2, Comparator<? super T> c) {
        boolean sorted1 = l1.stream()
                .sorted(c)
                .toList()
                .equals(l1);
        boolean sorted2 = l2.stream()
                .sorted(c)
                .toList()
                .equals(l2);
        List<T> result = null;
        if (sorted1 && sorted2) {
            result = Stream
                    .concat(l1.stream(), l2.stream())
                    .sorted(c)
                    .toList();
        }
        return result;
    }

}

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Exam {

    public static void main(String[] args) {
        MultiSet<Integer> s1 = new MultiSet<>();
        MultiSet<Integer> s2 = new MultiSet<>();
        MultiSet<Float> s3 = new MultiSet<>();
        s1.add(5);
        s1.add(7);
        s1.add(5);

        s2.add(5);
        s2.add(5);
        s2.add(7);

        s3.add(Float.valueOf(5));
        s3.add(Float.valueOf(5));
        s3.add(Float.valueOf(7));

        System.out.println(s1.equals(s2));
        System.out.println(s3.equals(s2));
    }

}

class MultiSet<T> {

    private Map<T, List<T>> set;

    public MultiSet() {
        set = new HashMap<>();
    }

    public void add(T t) {
        if (set.containsKey(t)) {
            var list = set.get(t);
            list.add(t);
            set.put(t, list);
        } else {
            List<T> list = new ArrayList<>();
            list.add(t);
            set.put(t, list);
        }
    }

    public void remove(T t) {
        if (set.containsKey(t)) {
            var list = set.get(t);
            list.remove(t);
            if (list.isEmpty()) {
                set.remove(t);
            } else {
                set.put(t, list);
            }
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        MultiSet<T> ms = (MultiSet<T>) other;
        if (set.size() != ms.set.size()) {
            return false;
        }
        for (T t : set.keySet()) {
            if (!ms.set.containsKey(t)) {
                return false;
            }
            if (set.get(t).size() != ms.set.get(t).size()) {
                return false;
            }
        }
        return true;
    }

}

import java.util.*;

public class SafeSet<T> {

    private Map<T, Boolean> set = new HashMap<>();

    public synchronized contains(Object o) {
        if(set.keySet().contains(o)){
            return set.get(o);
        }
        return false;
    }

    public synchronized boolean add(T t) {
        if (set.containsKey(t) && set.get(t)) {
            return false;
        }
        set.put(t, true);
        return true;
    }

    public synchronized boolean remove(Object o) {
        if (!set.containsKey(o)) {
            return false;
        }
        if (set.get(o)) {
            set.remove(o);
        } else {
            set.put(set.get(o), false);
        }
        return true;
    }

}

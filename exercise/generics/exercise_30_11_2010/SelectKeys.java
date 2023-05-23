import java.util.*;

public class SelectKeys {

    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        Map<Integer, String> m = new HashMap<>();
        m.put(1, "pujaz");
        m.put(3, "pujaz");
        m.put(5, "pujaz");
        m.put(7, "pujaz");
        System.out.println(SelectKeys.<Integer>selectKeysV1(l, m));
        System.out.println(selectKeysV2(l, m));
    }

    public static <T> List<T> selectKeysV1(List<? extends T> l, Map<?, ?> m) {
        List<T> res = new ArrayList<>();
        for (T t : l) {
            if (m.containsKey(t)) {
                res.add(t);
            }
        }
        return res;
    }

    public static List<?> selectKeysV2(List<?> l, Map<?, ?> m) {
        List<Object> res = new ArrayList<>();
        for (Object o : l) {
            if (m.containsKey(o)) {
                res.add(o);
            }
        }
        return res;
    }
}

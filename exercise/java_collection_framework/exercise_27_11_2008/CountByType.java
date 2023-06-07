import java.util.*;

public class CountByType {

    public static void main(String[] args) {
        List<Object> l = List.of(new Object(), new Object(), new Object(),
                Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3),
                "ciao", "mondo", " ", "!",
                new LinkedList<Object>(),
                new LinkedList<Object>(),
                new LinkedList<Integer>());
        countByType(l);
    }

    public static void countByType(List<?> l) {
        Map<Class<?>, Integer> m = new HashMap<>();
        for (Object o : l) {
            Class c = o.getClass();
            if (m.containsKey(c)) {
                int count = m.get(c);
                m.put(c, count + 1);
            } else {
                m.put(c, 1);
            }
        }
        for (Class c : m.keySet()) {
            System.out.println("Class [" + c.getName() + "] := " + m.get(c));
        }
    }

}

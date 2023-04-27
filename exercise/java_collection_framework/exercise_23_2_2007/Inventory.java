import java.util.*;

public class Inventory<T> {

    private Map<T, Integer> inventory;
    private T mostCommon;
    private Integer countMostCommon;

    public Inventory() {
        inventory = new HashMap<>();
    }

    public void add(T t) {
        if (inventory.containsKey(t)) {
            int count = inventory.get(t);
            inventory.put(t, count + 1);
            if (countMostCommon < count + 1) {
                mostCommon = t;
                countMostCommon = count + 1;
            }
        } else {
            inventory.put(t, 1);
            if (mostCommon == null) {
                mostCommon = t;
                countMostCommon = 1;
            }
        }
    }

    public Integer count(T t) {
        Integer count = inventory.get(t);
        return count == null ? 0 : count;
    }

    public T getMostCommon() {
        return mostCommon;
    }

    public static void main(String[] args) {
        Inventory<Integer> a = new Inventory<Integer>();
        Inventory<String> b = new Inventory<String>();
        a.add(7);
        a.add(6);
        a.add(7);
        a.add(3);
        b.add("ciao");
        b.add("allora?");
        b.add("ciao ciao");
        b.add("allora?");
        System.out.println(a.count(2));
        System.out.println(a.count(3));
        System.out.println(a.getMostCommon());
        System.out.println(b.getMostCommon());
    }

}

import java.util.*;

public class SortedList<T extends Comparable<? super T>> implements Iterable<T> {

    private List<T> list;
    private int size;

    public SortedList() {
        list = new LinkedList<>();
        size = 0;
    }

    public boolean add(T t) {
        if (size > 0) {
            ListIterator<T> iter = list.listIterator();
            while (iter.hasNext()) {
                T node = iter.next();
                if (node.compareTo(t) <= 0) {
                    iter.add(t);
                    break;
                }
            }
        } else {
            list.add(t);
        }
        size++;
        return true;
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }

    public static void main(String[] args) {
        SortedList<Integer> list = new SortedList<>();
        list.add(5);
        list.add(50);
        list.add(25);
        System.out.print("[ ");
        for (var n : list) {
            System.out.print(n + " ");
        }
        System.out.println("]");
    }

}

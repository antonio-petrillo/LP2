import java.util.*;

public class Merge {

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l2.add(4);
        l2.add(5);
        l2.add(6);
        System.out.println("Lista 1 := " + l1);
        System.out.println("Lista 2 := " + l2);
        System.out.println("Merged V1 := " + mergeV1(l1, l2));
        System.out.println("Merged V2 := " + mergeV2(l1, l2));
    }

    public static <T> LinkedList<T> mergeV1(List<T> l1, List<T> l2) {
        if (l1.size() != l2.size()) {
            throw new IllegalArgumentException("lists size doesn't match");
        }
        LinkedList<T> l = new LinkedList<>();
        Iterator<T> iter1 = l1.iterator();
        Iterator<T> iter2 = l2.iterator();
        while (iter1.hasNext()) {
            l.add(iter1.next());
            l.add(iter2.next());
        }
        return l;
    }

    public static <T> LinkedList<T> mergeV2(List<? extends T> l1, List<? extends T> l2) {
        if (l1.size() != l2.size()) {
            throw new IllegalArgumentException("lists size doesn't match");
        }
        LinkedList<T> l = new LinkedList<>();
        Iterator<? extends T> iter1 = l1.iterator();
        Iterator<? extends T> iter2 = l2.iterator();
        while (iter1.hasNext()) {
            l.add(iter1.next());
            l.add(iter2.next());
        }
        return l;
    }

}

import java.util.Iterator;
import java.util.RandomAccess;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Exercise {

    public static void main(String[] args) {
        List<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);

        System.out.println("l1 := " + l1);
        System.out.println("l2 := " + l2);

        Exercise.<Integer>reverse(l1);
        Exercise.<Integer>reverse(l2);

        System.out.println("l1 := " + l1);
        System.out.println("l2 := " + l2);
    }

    // Time := O(n), Space := O(n)
    // public static <T> void reverse(List<T> l){
    //     List<T> tmp = new ArrayList<>(l.size());
    //     for (Iterator<T> iter = l.iterator(); iter.hasNext();){
    //         tmp.add(iter.next());
    //         iter.remove();
    //     }
    //     for(int i = tmp.size() - 1; i >= 0; i--){
    //         l.add(tmp.get(i));
    //     }
    // }

    // T(n) = O(n), S(n) = O(n) if not random access
    // T(n) = O(n), S(n) = O(1) otherwise
    public static <T> void reverse(List<T> l){
        if (l instanceof RandomAccess){
            int size = l.size() - 1;
            for (int i = 0; i < size >> 1; i++){
                T tmp = l.get(i);
                l.set(i, l.get(size - i));
                l.set(size - i, tmp);
            }
        } else {
            List<T> tmp = new ArrayList<>(l.size());
            for (Iterator<T> iter = l.iterator(); iter.hasNext();){
                tmp.add(iter.next());
                iter.remove();
            }
            for(int i = tmp.size() - 1; i >= 0; i--){
                l.add(tmp.get(i));
            }
        }
    }

}

import java.util.*;

public class FunnyOrder implements Comparable<FunnyOrder> {
    private int val;

    public FunnyOrder(int n) {
        val = n;
    }

    public int compareTo(FunnyOrder x) {
        if (val % 2 == 0 && x.val % 2 != 0)
            return -1;
        if (val % 2 != 0 && x.val % 2 == 0)
            return 1;
        if (val < x.val)
            return -1;
        if (val > x.val)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        List<FunnyOrder> l = new LinkedList<FunnyOrder>();
        l.add(new FunnyOrder(16));
        l.add(new FunnyOrder(3));
        l.add(new FunnyOrder(4));
        l.add(new FunnyOrder(10));
        l.add(new FunnyOrder(2));
        Collections.sort(l);
        for (FunnyOrder f : l)
            System.out.println(f.val + " ");
        // Expected result:
        // ;=> 2, 4, 10, 16, 3
    }
}

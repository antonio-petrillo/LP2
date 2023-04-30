import java.util.*;

public class IsMax {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(5);
        set.add(23);
        set.add(5423);
        set.add(3241);

        System.out.println(IsMax.<Integer>isMax(1000, Integer::compare, set));
        System.out.println(IsMax.<Integer>isMax(10000, Integer::compare, set));

    }

    public static <T> boolean isMax(T x, Comparator<? super T> c, Set<? extends T> s){
        for(T t : s){
            if(c.compare(t, x) > 0){
                return false;
            }
        }
        return true;
    }

}

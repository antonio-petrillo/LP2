import java.util.*;

public class CountInBetween {

    public static <T> int countInBetween(T[] arr, T a, T b, Comparator<? super T> c) {
        int count = 0;
        for (T t : arr) {
            if (c.compare(t, a) >= 0 && c.compare(t, b) <= 0)
                count++;
        }
        return count;
    }

}

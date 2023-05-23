import java.util.Arrays;
import java.util.Comparator;

public class Driver {

    public static void main(String[] args) {
        Integer[] ar1 = new Integer[] { 1, 5, 2, 3, 56, 42 };
        Integer[] ar2 = new Integer[] { 1, 5, 2, 3, 56, 42 };
        Integer[] ar3 = new Integer[] { 1, 5, 2, 3, 56, 42 };
        Integer[] ar4 = new Integer[] { 1, 5, 2, 3, 56, 42 };

        System.out.println("\n--- print ---\n");

        System.out.println("ar1 " + Arrays.toString(ar1));
        System.out.println("ar2 " + Arrays.toString(ar2));
        System.out.println("ar3 " + Arrays.toString(ar3));
        System.out.println("ar4 " + Arrays.toString(ar4));

        System.out.println("\n--- sorted ---\n");

        Arrays.sort(ar1);
        Arrays.sort(ar2, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.signum(a - b);
            }
        });
        Arrays.sort(ar3, (Integer a, Integer b) -> Integer.signum(a - b));
        Arrays.sort(ar4, Integer::compare);

        System.out.println("ar1 " + Arrays.toString(ar1));
        System.out.println("ar2 " + Arrays.toString(ar2));
        System.out.println("ar3 " + Arrays.toString(ar3));
        System.out.println("ar4 " + Arrays.toString(ar4));
    }

}

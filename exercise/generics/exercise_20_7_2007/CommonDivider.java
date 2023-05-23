import java.util.*;

public class CommonDivider implements Iterable<Integer> {

    private Integer a, b;

    public CommonDivider(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int curr = 1;
            int gcd = gcd(a, b);

            @Override
            public boolean hasNext() {
                return curr <= gcd;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (curr < gcd) {
                    if (divide(curr, a) && divide(curr, b)) {
                        break;
                    }
                    curr++;
                }
                int res = curr;
                curr++;
                return res;
            }

        };
    }

    private boolean divide(int div, int num) {
        return num % div == 0;
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public static void main(String[] args) {
        for (Integer n : new CommonDivider(12, 60)) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

}

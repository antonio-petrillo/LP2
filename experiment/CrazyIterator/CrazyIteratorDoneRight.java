import java.util.Iterator;

public class CrazyIteratorDoneRight implements Iterator<Integer> {

    private int n = 1;

    public Integer next() {
        int j;
        while (true) {
            n++;
            for (j = 2; j <= n / 2; j++)
                if (n % j == 0 && n != j)
                    break;
            if (j > n / 2)
                break;
        }
        return Integer.valueOf(n);
    }

    public boolean hasNext() {
        return true;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Iterator<Integer> i = new CrazyIteratorDoneRight();
        while (i.hasNext()) {
            Integer n = i.next();
            if (n > 50)
                break;
            System.out.println(n);
        }
    }
}

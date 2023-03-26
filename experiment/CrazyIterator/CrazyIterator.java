public class CrazyIterator implements Iterator<Integer> {

    private int n = 0;

    public Integer next() {
        int j;
        while (true) {
            for (j=2; j<=n/2 ;j++)
                if (n % j == 0) break;
            if (j > n/2) break;
            n++;
        }
        return new Integer(n);
    }

    public boolean hasNext() {
        n++;
        return true;
    }

    public void remove() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Iterator i = new CrazyIterator();
        while (i.hasNext() &&
               (Integer)i.next()<10) {
            System.out.println(i.next());
        }
    }
}

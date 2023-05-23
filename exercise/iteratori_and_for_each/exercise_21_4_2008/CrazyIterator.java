import java.util.*;

public class CrazyIterator implements Iterator {
    private int n = 0;

    // ok
    public Object next() {
        int j;
        while (true) {
            for (j = 2; j <= n / 2; j++)
                if (n % j == 0)
                    break;
            if (j > n / 2)
                break;
            else
                n++;
        }
        return new Integer.valueOf(n);
    }

    // err, hasNext modifica lo stato dell'iteratore
    public boolean hasNext() {
        n++;
        return true;
    }

    // err, remove, qualora non supportata deve lanciare NoSuchElementException
    public void remove() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Iterator i = new CrazyIterator();

        while (i.hasNext() && (Integer) i.next() < 10) {
            // errore nell'utilizzo
            // viene chiamato next senza prima chiamare hasNext
            System.out.println(i.next());
        }
    }
}

import java.util.*;

public class B implements Comparator<Double> {

    public B(Boolean b) {

    }

    public int compare(Double a, Double b) {
        return Double.compare(a, b);
    }

    public static int g(String a, String b) {
        return a.compareTo(b);
    }

}

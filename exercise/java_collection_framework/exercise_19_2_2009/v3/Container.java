import java.util.Set;
import java.util.HashSet;

public class Container {

    private Integer[] connected;
    private Double[] amount;

    // O(1), O(1)
    public Container() {
        connected = new Integer[1];
        connected[0] = Integer.valueOf(1);
        amount = new Double[1];
        amount[0] = Double.valueOf(0);
    }

    public static void main(String[] args) {
        Container a = new Container();
        Container b = new Container();
        Container c = new Container();
        Container d = new Container();

        a.addWater(12.0);
        d.addWater(8.0);

        a.connect(b);

        System.out.println(a + " " + b + " " + c + " " + d);

        b.connect(c);

        System.out.println(a + " " + b + " " + c + " " + d);

        c.connect(d);

        System.out.println(a + " " + b + " " + c + " " + d);
    }

    // O(1), O(1)
    public Double getAmount() {
        return amount[0] / connected[0];
    }

    // O(1), O(1)
    public void addWater(Double amount) {
        this.amount[0] += amount;
    }

    // O(1), O(1)
    public void connect(Container c) {
        amount[0] += c.amount[0];
        connected[0] += c.connected[0];
        c.amount = amount;
        c.connected = connected;
    }

    // O(1), O(1)
    @Override
    public String toString() {
        return getAmount().toString();
    }

}

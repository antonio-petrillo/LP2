import java.util.Set;
import java.util.HashSet;

public class Container {

    private Group group;

    private static class Group {
        Integer connected;
        Double amount;
        Integer size;

        Group() {
            connected = 1;
            size = 1;
            amount = 0.;
        }
    }

    public Container() {
        group = new Group();
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

    public Double getAmount() {
        return group.amount / group.connected;
    }

    public void addWater(Double amount) {
        group.amount += amount;
    }

    public void connect(Container c) {
        if (group == c.group)
            return;
        group.amount += c.group.amount;
        group.connected += c.group.connected;
        c.group = group;
    }

    @Override
    public String toString() {
        return getAmount().toString();
    }

}

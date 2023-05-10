import java.util.*;

public class Container {
    private double amount;
    private Set<Container> group;

    public Container() {
        group = new HashSet<>();
        group.add(this);
    }

    // O(n)
    public void connectTo(Container other) {
        if (group == other.group) {
            return;
        }
        double size1 = group.size();
        double size2 = other.group.size();
        double tot1 = amount * size1;
        double tot2 = other.amount * size2;
        double newAmount = (tot1 + tot2) / (size1 + size2);

        group.addAll(other.group);

        for (Container c : other.group) {
            c.group = group;
        }

        for (Container c : group) {
            c.amount = newAmount;
        }
    }

    // O(1)
    public double getAmount() {
        return amount;
    }

    // O(n)
    public void addWater(double amount) {
        double newAmount = (this.amount + amount) / group.size();
        for (Container c : group) {
            c.amount = newAmount;
        }
    }

}

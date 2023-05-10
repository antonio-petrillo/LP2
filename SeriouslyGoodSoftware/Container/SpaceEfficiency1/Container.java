import java.util.*;

public class Container {
    private float amount;
    private List<Container> group;

    public Container() {
    }

    // O(n)
    public void connectTo(Container other) {
        if (group == null) {
            group = new ArrayList<>();
            group.add(this);
        }
        if (other.group == null) {
            other.group = new ArrayList<>();
            other.group.add(other);
        }
        if (group == other.group) {
            return;
        }
        int size1 = group.size();
        int size2 = other.group.size();

        float tot1 = amount * size1;
        float tot2 = other.amount * size2;
        float newAmount = (tot1 + tot2) / (size1 + size2);

        group.addAll(other.group);
        for (var c : other.group) {
            c.group = group;
        }

        for (var c : group) {
            c.amount = newAmount;
        }
    }

    // O(1)
    public float getAmount() {
        return amount;
    }

    // O(n)
    public void addWater(float amount) {
        if (group == null) {
            this.amount += amount;
        } else {
            float amountPerContainer = amount / group.size();
            for (var c : group) {
                c.amount += amountPerContainer;
            }
        }
    }

}

import java.util.*;

public class Container {

    private Group group;

    public Container() {
        group = new Group(this);
    }

    private static class Group {
        double amountPerContainer;
        Set<Container> members;

        Group(Container c) {
            members = new HashSet<>();
            members.add(c);
        }
    }

    // O(1)
    public void addWater(double amount) {
        group.amountPerContainer += amount / group.members.size();
    }

    // O(n)
    public void connectTo(Container other) {
        if (group.members == other.group.members) {
            return;
        }
        int size1 = group.members.size();
        int size2 = other.group.members.size();
        double newAmount = (group.amountPerContainer * size1 + other.group.amountPerContainer * size2)
                / (size1 + size2);
        group.amountPerContainer = newAmount;
        group.members.addAll(other.group.members);
        for (var c : other.group.members) {
            c.group = group;
        }
    }

    // O(1)
    public double getAmount() {
        return group.amountPerContainer;
    }

}

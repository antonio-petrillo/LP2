import java.util.*;

public class Container {

    private double amount;
    private Container parent;
    private int size;

    public Container() {
        parent = this;
        size = 1;
        amount = 0.;
    }

    public double getAmount() {
        Container root = find();
        return root.amount;
    }

    public void connectTo(Container c) {
        Container root = find();
        Container rootOther = c.find();
        if (root != rootOther) {
            int size = root.size;
            int sizeOther = rootOther.size;
            double newAmount = (root.amount * size + rootOther.amount * sizeOther) / (size + sizeOther);
            if (size > sizeOther) {
                rootOther.parent = root;
                root.amount = newAmount;
                root.size += rootOther.size;
            } else {
                root.parent = rootOther;
                rootOther.amount = newAmount;
                rootOther.size += root.size;
            }
        }
    }

    public void addWater(double amount) {
        Container root = find();
        root.amount += amount / root.size;
    }

    private Container find() {
        if (parent != this) {
            parent = parent.find();
        }
        return parent;
    }

}

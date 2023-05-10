
public class Container {
    private float amount;
    private Container[] group;

    public Container() {
    }

    // O(n)
    public void connectTo(Container other) {
        if (group == null) {
            group = new Container[] { this };
        }
        if (other.group == null) {
            other.group = new Container[] { other };
        }
        if (group == other.group) {
            return;
        }
        int size1 = group.length;
        int size2 = other.group.length;

        float tot1 = amount * size1;
        float tot2 = other.amount * size2;
        float newAmount = (tot1 + tot2) / (size1 + size2);

        Container[] newGroup = new Container[size1 + size2];
        int i = 0;

        for (var c : group) {
            c.group = newGroup;
            c.amount = newAmount;
            newGroup[i++] = c;
        }

        for (var c : other.group) {
            c.group = newGroup;
            c.amount = newAmount;
            newGroup[i++] = c;
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
            float amountPerContainer = amount / group.length;
            for (var c : group) {
                c.amount += amountPerContainer;
            }
        }
    }

}

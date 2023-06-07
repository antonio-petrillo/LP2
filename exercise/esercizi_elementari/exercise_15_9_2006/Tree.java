import java.util.*;

public class Tree implements Cloneable {

    private static int treeCount = 0;

    private TreeType tt;
    private Set<TreeType> grafts;

    public Tree(TreeType tt) {
        this.tt = tt;
        grafts = new HashSet<>();
        treeCount++;
    }

    public Tree clone() {
        var t = new Tree(tt);
        t.grafts.addAll(grafts);
        return t;
    }

    public static int getCounter() {
        return treeCount;
    }

    public void addGraft(TreeType graft) {
        if (tt.equals(graft)) {
            throw new IllegalArgumentException("Impossibile fare innesti con 2 " + tt.toString());
        }
        grafts.add(tt);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("innesti:\n");
        System.out.println("innesti:");
        for (var tt : grafts) {
            sb.append(tt + "\n");
        }
        return sb.toString();
    }

}

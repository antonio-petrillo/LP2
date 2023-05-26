import java.util.*;

public class TreeType {
    private static Map<String, Integer> trees = new HashMap<>();

    private String type;

    public TreeType(String type) {
        this.type = type;
        trees.put(type, trees.getOrDefault(type, 0) + 1);
    }

    protected void updateTreeCount() {
        trees.put(type, trees.get(type) + 1);
    }

    public int getCounter() {
        return trees.get(type);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TreeType))
            return false;
        TreeType tt = (TreeType) o;
        return type.equals(tt.type);
    }

    @Override
    public String toString() {
        return type;
    }

}

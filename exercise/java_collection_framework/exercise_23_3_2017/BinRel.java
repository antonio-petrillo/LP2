import java.util.*;

public class BinRel<T> {

    private Map<T, Set<T>> relation;

    public BinRel() {
        relation = new HashMap<>();
    }

    public void addPair(T x, T y) {
        Set<T> inRelationWith;
        if (relation.containsKey(x)) {
            inRelationWith = relation.get(x);
        } else {
            inRelationWith = new HashSet<>();
        }
        inRelationWith.add(y);
        relation.put(x, inRelationWith);
    }

    public boolean areRelated(T x, T y) {
        return relation.containsKey(x) && relation.get(x).contains(y);
    }

    public boolean isSymmetric() {
        for (T t1 : relation.keySet()) {
            for (T t2 : relation.get(t1)) {
                if (!relation.containsKey(t2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinRel<String> rel = new BinRel<>();
        rel.addPair("a", "albero");
        rel.addPair("a", "amaca");
        System.out.println(rel.isSymmetric());
        rel.addPair("albero", "a");
        rel.addPair("amaca", "a");
        System.out.println(rel.isSymmetric());
        System.out.println(rel.areRelated("a", "amaca"));
    }

}

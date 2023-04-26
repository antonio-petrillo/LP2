import java.util.*;

public class BoolVar implements BoolExpr {

    private String label;

    public BoolVar(String label) {
        this.label = label;
    }

    @Override
    public boolean eval(Map<? extends BoolExpr, Boolean> table) {
        if (!table.containsKey(this)) {
            throw new IllegalArgumentException("label not found");
        }
        return table.get(this);
    }

}

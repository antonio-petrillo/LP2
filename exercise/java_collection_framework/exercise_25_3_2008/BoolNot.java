import java.util.*;

public class BoolNot implements BoolExpr {

    private BoolExpr var;

    public BoolNot(BoolExpr var) {
        this.var = var;
    }

    public boolean eval(Map<? extends BoolExpr, Boolean> table) {
        return !var.eval(table);
    }

}

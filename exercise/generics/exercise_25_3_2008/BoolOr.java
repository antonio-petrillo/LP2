import java.util.*;

public class BoolOr implements BoolExpr {

    private BoolExpr x, y;

    public BoolOr(BoolExpr x, BoolExpr y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean eval(Map<? extends BoolExpr, Boolean> table) {
        return x.eval(table) || y.eval(table);
    }
}

import java.util.*;

public interface BoolExpr {

    public boolean eval(Map<? extends BoolExpr, Boolean> table);

}

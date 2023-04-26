import java.util.*;

public class Driver {

    public static void main(String[] args) {
        BoolVar x = new BoolVar("x");
        BoolVar y = new BoolVar("y");
        BoolExpr notx = new BoolNot(x);
        BoolExpr ximpliesy = new BoolOr(notx, y);
        Map<BoolVar, Boolean> m = new HashMap<BoolVar, Boolean>();
        m.put(x, true);
        m.put(y, true);
        System.out.println(x.eval(m));
        System.out.println(ximpliesy.eval(m));
        m.put(y, false);
        System.out.println(ximpliesy.eval(m));
    }

}

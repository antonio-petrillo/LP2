import java.util.*;

public class Molecola {
    private Map<Elemento, Integer> composition = new TreeMap<>();

    public void add(Elemento e) {
        if (composition.containsKey(e)) {
            Integer val = composition.get(e);
            composition.put(e, val + 1);
        } else {
            composition.put(e, 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Elemento e : composition.keySet()) {
            if (!first) {
                sb.append(" ");
            }
            first = false;
            sb.append(e.toString());
            Integer value = composition.get(e);
            if (value > 1) {
                sb.append(value);
            }
        }
        return sb.toString();
    }

}

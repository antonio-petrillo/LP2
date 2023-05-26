import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ControllerBest {

    private Map<String, Function> functions = new HashMap<>();

    public Function addFunction(String name) {
        Function f = new Function(name);
        if (!functions.containsKey(name)) {
            functions.put(name, f);
        } else {
            f = functions.get(name);
        }
        return f;
    }

    public void printOn() {
        for (Function f : functions.values()) {
            if (f.active) {
                System.out.println(f);
            }
        }
    }

    public static class Function {

        private String name;
        private boolean active;
        private List<Function> incompatibleWith;

        private Function(String name) {
            this.name = name;
            this.incompatibleWith = new ArrayList<>();
        }

        public void setIncompatible(Function f) {
            if (!incompatibleWith.contains(f)) {
                incompatibleWith.add(f);
                f.setIncompatible(this);
            }
            if (active && f.active) {
                f.active = false;
            }
        }

        public void turnOn() {
            active = true;
            for (Function f : incompatibleWith) {
                f.active = false;
            }
        }

        public void turnOff() {
            active = false;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Function)) {
                return false;
            }
            Function f = (Function) o;
            return name.equals(f.name);
        }

        @Override
        public String toString() {
            return name;
        }

    }

    public static void main(String[] args) {
        ControllerBest c = new ControllerBest();

        ControllerBest.Function ac = c.addFunction("Aria condizionata");
        ControllerBest.Function risc = c.addFunction("Riscaldamento");
        ControllerBest.Function sedile = c.addFunction("Sedile riscaldato");

        ac.setIncompatible(risc);
        ac.setIncompatible(sedile);

        ac.turnOn();
        c.printOn();

        System.out.println("−−−−");

        risc.turnOn();
        sedile.turnOn();

        c.printOn();
    }

}

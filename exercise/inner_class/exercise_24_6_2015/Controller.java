import java.util.List;
import java.util.ArrayList;

public class Controller {

    private List<Function> functions = new ArrayList<>();

    public Function addFunction(String name) {
        // La traccia non specifica nulla nel caso ci siano piú function uguali
        // Ci sono tre opzioni:
        //
        // 1. ritornare il nuovo oggetto creato, potrebbe confondere un eventuale client
        //
        // 2. ritornare null, a mio parere migliore del primo,
        // ma comunque se quella function esiste giá, il client potrebbe essere
        // interessato a quell'oggetto, ad esempio nel caso in cui ha perso il
        // riferimento ad essa.
        //
        // 3. ritornare l'oggetto giá presente nella lista delle funzioni
        //
        Function f = new Function(name);
        if (!functions.contains(f)) {
            functions.add(f);
        } else {
            // 1. return f
            //
            // 2. f = null;
            //
            // 3. ritornare la vecchia function
            // Qua una hashmap sarebbe piú adeguata di una lista
            for (Function other : functions) {
                if (other.equals(f)) {
                    f = other;
                    break;
                }
            }
        }
        return f;
    }

    public void printOn() {
        for (Function f : functions) {
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
        Controller c = new Controller();

        Controller.Function ac = c.addFunction("Aria condizionata");
        Controller.Function risc = c.addFunction("Riscaldamento");
        Controller.Function sedile = c.addFunction("Sedile riscaldato");

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

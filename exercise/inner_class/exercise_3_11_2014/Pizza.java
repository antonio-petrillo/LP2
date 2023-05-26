import java.util.*;

public class Pizza implements Comparable<Pizza>, Cloneable {

    private Set<Ingrediente> composizione;
    private double calorie;

    public Pizza() {
        composizione = EnumSet.noneOf(Ingrediente.class);
        calorie = 0.;
    }

    public static enum Ingrediente {
        POMODORO(250.), MOZZARELLA(350.50), AGLIO(42.42);

        private double calorie;

        private Ingrediente(double calorie) {
            this.calorie = calorie;
        }
    }

    public void addIngrediente(Ingrediente i) {
        if (!composizione.contains(i)) {
            composizione.add(i);
            calorie += i.calorie;
        }
    }

    public Pizza clone() {
        Pizza p = new Pizza();
        p.composizione.addAll(composizione);
        p.calorie = calorie;
        return p;
    }

    public int compareTo(Pizza p) {
        return Double.compare(calorie, p.calorie);
    }

    public static void main(String[] args) {
        Pizza margherita = new Pizza();
        Pizza marinara = new Pizza();

        margherita.addIngrediente(Pizza.Ingrediente.POMODORO);
        margherita.addIngrediente(Pizza.Ingrediente.MOZZARELLA);
        marinara.addIngrediente(Pizza.Ingrediente.POMODORO);
        marinara.addIngrediente(Pizza.Ingrediente.AGLIO);

        Pizza altra = margherita.clone();

        System.out.println(altra.compareTo(marinara));
    }

}

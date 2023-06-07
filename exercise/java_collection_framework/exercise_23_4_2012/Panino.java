import java.util.*;

public class Panino {

    private Set<Ingrediente> composizione;
    private int ingredientiUtilizzati;

    public Panino() {
        composizione = EnumSet.noneOf(Ingrediente.class);
        ingredientiUtilizzati = 0;
    }

    public static enum Ingrediente {
        PROSCIUTTO((byte) 0x01), SALAME((byte) 0x01), SOTTILETTA((byte) 0x02), MOZZARELLA((byte) 0x02),
        MAIONESE((byte) 0x04),
        SENAPE((byte) 0x04);

        private byte categoria;

        private Ingrediente(byte c) {
            this.categoria = c;
        }
    }

    public void addIngrediente(Ingrediente i) {
        if ((ingredientiUtilizzati & i.categoria) > 0) {
            throw new IllegalArgumentException("Ingrediente giá utilizzato");
        }
        ingredientiUtilizzati |= i.categoria;
        composizione.add(i);
    }

    @Override
    public String toString() {
        String comp = composizione.toString();
        return "Panino con " + (comp.length() == 2 ? "NULLA" : comp.substring(1, comp.length() - 1));
    }

    public static void main(String[] args) {
        Panino p = new Panino();
        System.out.println(p);
        p.addIngrediente(Panino.Ingrediente.SALAME);
        p.addIngrediente(Panino.Ingrediente.SOTTILETTA);
        System.out.println(p);
        p.addIngrediente(Panino.Ingrediente.MOZZARELLA);
    }

}

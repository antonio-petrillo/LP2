import java.util.*;

public class Panino {

    private Set<Ingrediente> composizione;
    private Map<Categoria, Ingrediente> usati;

    public Panino() {
        composizione = EnumSet.noneOf(Ingrediente.class);
        usati = new EnumMap<>(Categoria.class);
    }

    private static enum Categoria {
        RIPIENI, FORMAGGI, SALSE;
    }

    public static enum Ingrediente {
        PROSCIUTTO(Categoria.RIPIENI), SALAME(Categoria.RIPIENI), SOTTILETTA(Categoria.FORMAGGI),
        MOZZARELLA(Categoria.FORMAGGI),
        MAIONESE(Categoria.SALSE),
        SENAPE(Categoria.SALSE);

        private Categoria categoria;

        private Ingrediente(Categoria c) {
            this.categoria = c;
        }
    }

    public void addIngrediente(Ingrediente i) {
        if (usati.containsKey(i.categoria)) {
            throw new IllegalArgumentException("Ingrediente giá utilizzato");
        }
        usati.put(i.categoria, i);
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

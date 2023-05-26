public class Exam {

    private String nome;
    private String matricola;

    private Studente(String nome, String matricola){
        this.nome = nome;
        this.matricola = matricola;
    }

    public String toString() {
        return nome + "\t" + matricola;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Studente)) {
            return false;
        }
        Studente s = (Studente) o;
        return nome.equals(s.nome) && matricola.equals(s.matricola);
    }

    public static class Triennale extends Studente {
        private static String prefix;

        public static void setPrefisso(String prefix) {
            Triennale.prefix = prefix;
        }

        public Triennale(String nome, String matricola) {
            super(nome, prefix + "/" + matricola);
        }
    }

    public static class Magistrale extends Studente {
        private static String prefix;

        public static void setPrefisso(String prefix) {
            Magistrale.prefix = prefix;
        }

        public Magistrale(String nome, String matricola) {
            super(nome, prefix + "/" + matricola);
        }
    }

    public static void main(String[] args) {
        Studente.Triennale.setPrefisso("N86");
        Studente.Magistrale.setPrefisso("N97");
        Object luca1 = new Studente.Triennale("Luca", "004312");
        Object luca2 = new Studente.Triennale("Luca", "004312");
        Object anna1 = new Studente.Triennale("Anna", "004312");
        Object anna2 = new Studente.Magistrale("Anna", "004312");
        System.out.println(luca1.equals(luca2));
        System.out.println(anna1.equals(anna2));
        System.out.println(anna1);
    }

}

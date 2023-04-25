public class Elemento implements Comparable<Elemento> {

    private String sigla;

    public Elemento(String sigla) {
        this.sigla = sigla;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Elemento)) {
            return false;
        }
        Elemento e = (Elemento) o;
        return sigla.equals(e.sigla);
    }

    @Override
    public String toString() {
        return sigla;
    }

    @Override
    public int compareTo(Elemento e) {
        return sigla.compareTo(e.sigla);
    }

}

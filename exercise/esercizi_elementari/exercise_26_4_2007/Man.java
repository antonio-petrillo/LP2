public class Man implements Person {

    private String nome;
    private String cognome;

    private Person father;
    private Person mother;
    private Person wife;

    public Man(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

}

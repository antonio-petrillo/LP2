import java.util.*;

public class Woman implements Person {

    private String nome;
    private String cognome;
    private Person father;
    private Person mother;

    public Woman(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public boolean areSibling(Person p) {

    }

    @Override
    public boolean addChild(Person p);

    @Override
    public boolean marries(Person p);
}

import java.util.*;

public abstract class Person {
    private String nome;
    private String cognome;

    private Person coniuge;
    protected Person madre;
    protected Person padre;

    private Set<Person> figli;

    protected Person(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
        figli = new HashSet<>();
    }

    public void addChild(Person p){
       figli.add(p);
    }

    public final void marries(Person p){
        if(p == null){
            throw new IllegalArgumentException("cannot marrie null, it is a bad Person");
        }
        if (getClass() == p.getClass()){
            throw new IllegalArgumentException("cannot marrie a person of the same sex");
        }
        coniuge = p;
        p.coniuge = this;
    }

    public static final boolean areSiblings(Person a, Person b){
        if (a.padre != null && b.madre != null){
            return a.padre.coniuge == b.madre;
        } else if (a.madre != null && b.padre != null){
            return b.madre.coniuge == a.padre;
        }
        return false;
    }
}

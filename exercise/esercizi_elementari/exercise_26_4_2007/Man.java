public class Man extends Person {

    protected Person wife;

    public Man(String nome, String cognome){
        super(nome, cognome);
    }

    @Override
    public void addChild(Person p){
        super.addChild(p);
        p.padre = this;
    }

}

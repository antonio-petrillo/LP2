public class Woman extends Person {

    protected Person husband;

    public Woman(String nome, String cognome){
        super(nome, cognome);
    }

    @Override
    public void addChild(Person p){
        super.addChild(p);
        p.madre = this;
    }

}

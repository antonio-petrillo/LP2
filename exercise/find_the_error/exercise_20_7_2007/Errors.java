public class Errors {
    private Errors e = null;
    //private Class<? extends String> c = String.getClass(); // getClass on non instance field
    private Class<? extends String> c = String.class; // getClass on non instance field

    public Errors(Errors ee) {
        e = ee;
    }

    public Errors() {
        this(this); //?, non posso passare this ad un'altro costruttore della classe
    }

    public boolean f() {
        Class<?> old_c = c;
        c = Object.class; // c é definito come ? extends String, quindi ? extends Object non é suo sottotipo.
        return (old_c == c);
    }
}

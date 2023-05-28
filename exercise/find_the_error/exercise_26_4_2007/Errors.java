public class Errors {
    private static int sval = 7;
    private int val = sval;

    public Errors() {
        super(); // ?
    }

    private class A {
        private A(int n) {
            val += n;
        }
    }

    private class B extends A {
        // B() { val = sval; } // can't access val
        // B() don't call super
    }

    public static void main(String[] args) {
        //Errors t = new Errors; //mancano le parentesi
        Errors t = new Errors();
        A a = t.new A(5);
        // B b = a.new B(); // this is not a class of A
    }
}

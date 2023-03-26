class A {
    public String f(Object a, A b) { return "A1"; }
    public String f(A a, B b) { return "A2"; } //more specific
}

class B extends A {
    public String f(B a, B b) { return "B1␣+␣" + f(a, (A)b); } //more specific
    public String f(A a, B b) { return "B2"; } }

public class Exercise {
    public static void main(String[] args) {
        B beta = new B();
        A alfa = beta;
        System.out.println(alfa.f(beta, null)); // B1:A1, ? why B2
        System.out.println(beta.f(beta, beta)); // B1:A1
        System.out.println(beta.f(alfa, null)); // B2
    }
}

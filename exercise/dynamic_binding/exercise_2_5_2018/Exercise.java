class A {
    public String f(Object a, A b) { return "A1"; }
    public String f(A a, C b) { return "A2"; }
}

class B extends A {
    public String f(Object a, A b) { return "B1␣+␣" + f(null, new B()); }
    private String f(A a, B b) { return "B2"; }
}

class C extends B {
    public String f(Object a, B b) { return "C1"; }
    public String f(A a, B b) { return "C2"; }
}

public class Exercise {
    public static void main(String[] args) {
        C gamma = new C();
        B beta = gamma;
        A alfa = gamma;
        System.out.println(alfa.f(beta, gamma)); // A2
        System.out.println(beta.f(beta, beta));  // B1:B2
        System.out.println(gamma.f(alfa, null)); // A2
        System.out.println(beta instanceof A); // true
    } }

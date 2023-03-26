class A {

    public String f(Object x, A y, B z) {
        return "A1";
    }

    // more specific
    public String f(A x, C y, C z) {
        return "A2";
    }

}

class B extends A {

    public String f(Object x, A y, A z) {
        return "B1␣+␣" + f(null, new B(), y);
    }

    // more specific
    private String f(A x, B y, B z) {
        return "B2";
    }
}

class C extends B {

    public String f(A x, A y, B z) {
        return "C1";
    }

    // more specific
    public String f(A x, C y, C z) {
        return "C2";
    }

}

public class Exercise {
    public static void main(String[] args) {
        C gamma = new C();
        B beta = gamma;
        A alfa = gamma;
        System.out.println(alfa.f(beta, gamma, gamma)); // C2
        System.out.println(beta.f(beta, beta, beta));   // A1
        System.out.println(gamma.f(alfa, null, beta));  // C1
    }
}

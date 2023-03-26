
public class MethodCandidate {

    public static void main(String[] args) {
        C gamma = new C();
        B beta = new B();
        A alfa = beta;
        // System.out.println(alfa.f(3, beta));
        System.out.println(alfa.f(3.0, beta));
        System.out.println(beta.f(3.0, alfa));
        // System.out.println(gamma.f(3, gamma));
        System.out.println(false || alfa.equals(beta));
    }

}

class A {
    public String f(double n, A x) {
        return "A1";
    }

    public String f(double n, B x) {
        return "A2";
    }

    public String f(int n, Object x) {
        return "A3";
    }
}

class B extends A {
    public String f(double n, B x) {
        return "B1";
    }

    public String f(float n, Object y) {
        return "B2";
    }
}

class C extends A {
    public final String f(int n, Object x) {
        return "C1";
    }
}

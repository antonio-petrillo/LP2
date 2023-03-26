public class Exercise {

    public static void main(String[] args) {
        C gamma = new C();
        B beta = gamma;
        A alpha = gamma;

        System.out.println(alpha.f(beta, gamma)); // A3
        System.out.println(beta.f(beta, beta)); // B2 // err beta have effective type C => C2
        System.out.println(gamma.f(alpha, null)); // C2
        System.out.println(beta instanceof A); // true
    }

}

// class A compile
class A {

    public String f(Object a, B b) {
        return "A1";
    }

    public String f(A a, A b) {
        return "A2";
    }

    public String f(B a, C b) {
        return "A3";
    }
}

class B extends A {

    public String f(Object a, B b) {
        return "B1 + " + f(null, new B());
    }

    // this is more specific
    public String f(A a, B b) {
        return "B2";
    }

}

class C extends B {

    public String f(Object a, B b) {
        return "C1";
    }

    public String f(A a, B b) {
        return "C2";
    }

}

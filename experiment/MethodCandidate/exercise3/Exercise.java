public class Exercise {

    public static void main(String[] args) {
        C gamma = new C();
        B beta = gamma;
        A[] array = new A[10];
        System.out.println(beta.f(gamma, array, gamma)); // should print B1
        // System.out.println(gamma.f(array[0], null, beta)); // compile error
        // ↑ can't distinguish between: C1, B1 (B1 and C1 are more specifial than A1 and A2)
        System.out.println(beta == gamma); // should print true
    }

}

class A {
    public String f(A x, A[] y, B z) {
        return "A1";
    }

    public String f(A x, Object y, B z) {
        return "A2";
    }
}

class B extends A {
    public String f(B x, A[] y, B z) {
        return "B1:" + x.f((A) x, y, z);
    }

    public String f(A x, B[] y, B z) {
        return "B2";
    }
}

class C extends B {
    public String f(A x, A[] y, C z) {
        // return "C1:" + z.f(new C(), y, z);
        return "";
    }
}

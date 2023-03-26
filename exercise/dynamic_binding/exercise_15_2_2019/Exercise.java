public class Exercise {

    public static void main(String[] args) {
        C gamma = new C();
        B beta = gamma;
        B[] array = new B[10];

        System.out.println(beta.f(gamma, array));  // B1:B2
        System.out.println(gamma.f(beta, null));   // C1
        System.out.println(beta.f(array[0], null));// B2

    }

}

class A {

    // more specific
    public String f(A x, A[] y){
       return "A1";
    }

    public String f(A x, Object y){
       return "A2:" + x.f(new C(), y);
    }

}

class B extends A {

    // more specific than below
    public String f(C x, A[] y){
        return "B1:" + x.f((A) x, y);
    }

    // more specific than below
    public String f(A x, A[] y){
        return "B2";
    }

    public String f(A x, Object[] y){
        return "B3";
    }

}

class C extends B {

    public String f(A x, B[] y){
        return "C1";
    }

}

public class Exercise {

    public static void main(String[] args) {
        B beta = new B();
        A alpha = beta;

        System.out.println(alpha.f(alpha, alpha, null)); // B1:B2
        System.out.println(beta.f(alpha, beta, beta));   // B2
        // System.out.println(beta.f(beta, beta, beta));    // compile error f(A,B,B), f(B, Obj, B)
        System.out.println(beta.f(alpha, alpha, null));  // B1:B2
    }

}

class A {

    // more specfic than A2
    public String f(A x, A y, B z){
        return "A1";
    }

    public String f(A x, Object y, A z){
        return "A2";
    }

    // more specfic than A2
    public String f(B x, Object y, B z){
        return "A3";
    }

}

class B extends A {

    public String f(A x, A y, B z){
        return "B1:" + f(x, this, z);
    }

    // more specfic than B1 and B3
    public String f(A x, B y, B z){
        return "B2";
    }

    public String f(B x, Object y, B z){
        return "B3";
    }
}

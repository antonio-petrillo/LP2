public class Exercise {

    public static void main(String[] args) {

        B beta = new B();
        A alpha = beta;
        System.out.println(alpha.f(beta, null)); // A3
        System.out.println(beta.f(beta, beta)); // B1:B2
        System.out.println(beta.f(alpha, (B) null)); // A3

    }

}

class A {

    public String f(Object x, A y){
        return "A1";
    }

    public String f(A x, Object y){
        return "A2";
    }

    public String f(A x, B y){
        return "A3";
    }

}

class B extends A {

    public String f(B x, B y){
        return "B1:" + f(x, (Object) y);
    }

    public String f(A x, Object y){
        return "B2";
    }
}

class C extends B {

    public String f(A x, Object y){
        return "C1:" + f(x, (B)y);
    }

    public String f(Object x, A y){
        return "C2";
    }
}

public class Exercise {

    public static void main(String[] args) {
        B beta = new B();
        A alfa = beta;
        System.out.println(alfa.f(null, alfa)); // A3
        System.out.println(beta.f(beta, beta)); // B1, A3
        System.out.println(beta.getClass() == alfa.getClass());
    }

}

class A {

    // 1
    public String f(Object x, B b){
        return "A 1";
    }

    // 2
    public String f(B b1, B b2){
        return "A 2" + f(b1, b2);
    }

    // 3
    public String f(A a, Object x){
        return "A 3";
    }

}

class B extends A {

    // 1
    public String f(B b1, B b2){
        return "B 1, " + f(null, (A) b2);
    }

    // 2
    public String f(Object x, B b){
        // return "B 2, " + f(x, (A) x); // won't compile, no candidate for f(Object o, A a) in this class
        return "B 2";
    }

    // 3
    public String f(A a, B b){
        return "B 3, " + f(b, b);
    }

}

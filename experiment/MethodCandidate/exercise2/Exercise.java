
public class Exercise {

    public static void main(String[] args) {
        C gamma = new C();
        B beta = new B();
        A alpha = beta;

        // System.out.println(alfa.f(3.0, gamma)); // compile error // Correct
        // ↑ can't choice between A1 and A2
        // System.out.println(beta.f(3, beta)); // compile error // Correct
        // ↑ can't choice between B1 and B2
        System.out.println(beta.f(3.0, null)); // print B1 // Err print A2
        System.out.println(gamma.f(3.0, gamma)); // print C1 // Err print A2

        // The methods in B and C aren't more specific that the one in A


    }

}

class A {

    public String f(double n, Object x) {
        return "A1";
    }

    public String f(double n, A a) {
        return "A2";
    }

    public String f(int n, Object x) {
        return "A3";
    }

}

class B extends A {

    public String f(double n, Object x) {
        return "B1";
    }

    public String f(float n, Object y) {
        return "B2";
    }

}

class C extends B {

    public String f(double n, Object x) {
        return "C1";
    }

}

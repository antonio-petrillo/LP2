public class Exercise {

    public static void main(String[] args) {
        B[] arrayB = new B[10];
        A[] arrayA = arrayB;
        arrayB[0] = new B();
        System.out.println(arrayB[0].f(null, arrayB));    // B1
        System.out.println(arrayA[0].f(null, arrayA));    // B2
        System.out.println(arrayA[0].f(arrayA[0], null)); // B2
    }

}

class A {

    // more specific
    public String f(A x, A[] y) {
        return "A1";
    }

    public String f(A x, Object y) {
        return "A2, " + x.f(new B(), null);
    }

}

class B extends A {

    // more specific than the one below
    public String f(B x, B[] y){
        return "B1";
    }

    // more specific than the one below
    public String f(A x, A[] y){
        return "B2";
    }

    public String f(A x, Object[] y){
        return "B3";
    }

}

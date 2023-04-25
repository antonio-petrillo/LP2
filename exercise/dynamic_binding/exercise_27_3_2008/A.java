public class A {
    private int f(double a, int b, A c) {
        return 1;
    }

    private int f(double a, float b, A c) {
        return 20;
    }

    private int f(long a, float b, B c) {
        return 10;
    }

    public static void main(String[] args) {
        B beta = new B();
        A alfa = beta;

        System.out.println(alfa.f(1, 2, alfa));   // 1
        // System.out.println(alfa.f(1, 2, null));// ambiguo
        // System.out.println(alfa.f(1, 2, beta));// ambiguo
        System.out.println(alfa.f(1.0, 2, beta)); // 1
        System.out.println(1234 & 1234);
    }
}

class B extends A{

    private int f(double a, float b, A c) {
        return 30;
    }

    private int f(int a, int b, B c) {
        return 40;
    }

}

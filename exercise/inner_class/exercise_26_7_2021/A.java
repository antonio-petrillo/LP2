public class A {
    public int n;
    private A myself = this;

    public static class B extends A {
        int i = 1;
    }

    public class C {
        int j = 2;
    }

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A.B();
        A.C c1 = a1.new C();
        A.C c2 = a2.new C();
    }
}

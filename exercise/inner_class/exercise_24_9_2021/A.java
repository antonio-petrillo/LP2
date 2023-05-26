public class A {
    public int n = 0;
    private C c = new C();

    public static class B {
        int i = 1;
    }

    public class C {
        int j = 2;

        public C() {
            A.this.n++;
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A.B b = new A.B();
        A.C c = new A.C();
    }
}

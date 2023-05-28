public class B {

    public B(int i) {
    }

    public static class C extends A {
        public C(int i) {
            super(i);
        }
    }

    public static class D extends B {
        public D(int i) {
            super(i);
        }
    }

}

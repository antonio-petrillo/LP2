public class B implements Cloneable {

    public B() {
    }

    public B(boolean b) {
    }

    public static class C extends B {
        public C(boolean b) {
            super(b);
        }

        public C(int n) {
        }
    }

    public B f(Object o) {
        return this;
    }

    @Override
    public B clone() {
        return new B();
    }

}

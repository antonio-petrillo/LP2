public class B implements Cloneable {
    private boolean b;

    private B() {
    }

    public B(boolean b) {
        this.b = b;
    }

    public B clone() {
        return null;
    }

    public B f(Object o) {
        return this;
    }

    public static class C extends B {

        private int i;

        public C(boolean c) {
            super(c);
        }

        public C(int i) {
            this.i = i;
        }

    }

}

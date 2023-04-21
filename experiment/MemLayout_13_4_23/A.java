public class A {
    private A other;

    public A(A other) {
        this.other = other;
    }

    public class B {
        private static int counter = 0;
        private int id;

        public B() {
            id = counter++;
            System.out.println("id" + id);
        }
    }

    public Object makeObj(int val) {
        return new B() {
            private int j = val;
        };
    }

    public static void main(String[] args) {
        A a1 = new A(null);
        A a2 = new A(a1);
        A.B b = a1.new B();
        Object x = a1.makeObj(42);
        Object y = a2.makeObj(42);
    }
}

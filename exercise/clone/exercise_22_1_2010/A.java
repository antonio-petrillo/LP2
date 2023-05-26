public class A extends B {

    private B.C c = new B.C(3);
    private B b1, b2;

    public A() {
        b1 = new B.C(true);
        b2 = new B(false);
    }

    @Override
    public B f(Object o) {
        B x = super.f(o);
        return x.clone();
    }
}

import java.lang.reflect.Field;

public class Reset {

    public static void main(String[] args) throws IllegalAccessException {
        A a = new A();
        B b = new B();
        C c = new C();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        System.out.println("--- RESET ---");
        reset(a);
        reset(b);
        reset(c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void reset(Object o) throws IllegalAccessException {
        for (Field f : o.getClass().getFields()) {
            if (f.getType() == Integer.class || f.getType() == int.class) {
                f.setInt(o, 0);
            }
        }
    }

}

class A {
    public int a = 1;

    @Override
    public String toString() {
        return " a -> " + a;
    }
}

class B extends A {
    private int b = 2;

    @Override
    public String toString() {
        return " b -> " + b + super.toString();
    }
}

class C extends B {
    public int c = 3;

    @Override
    public String toString() {
        return " c -> " + c + super.toString();
    }
}

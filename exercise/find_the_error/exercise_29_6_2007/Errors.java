import java.util.*;

public class Errors {
    private static int num = 7;
    private Integer z = 8;
    // Map<Integer, Errors> m = new Map<Integer, Errors>(); // Map is not a concrete
    // class
    Map<Integer, Errors> m = new HashMap<Integer, Errors>(); // Map is not a concrete class

    public Errors() {
    }

    private static class A {
        private A() {
            // num += z; // can't access the field from Errors
            // A is static so it doesn't have the A.this reference
        }
    }

    private void f() {
        m.put(7, new Errors() {
            public int g() {
                return 0;
            }
        });
    }

    public static final A a = new A();
}

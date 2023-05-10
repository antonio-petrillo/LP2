import java.lang.reflect.*;

public class Driver {

    public static void main(String[] args) throws Exception {
        Person p1 = new Person("sucuz", "zone");
        Employee e1 = new Employee("papa", "pujaz", 13);
        Manager m1 = new Manager("Nun scenn", "cretin", 15, 15);

        Person p2 = e1;
        Person p3 = m1;
        Employee e2 = m1;

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(e2);

        Class<? extends Person> c1 = p1.getClass();
        Class<? extends Person> c2 = p2.getClass();
        Class<? extends Person> c3 = p3.getClass();
        Class<? extends Employee> c4 = e2.getClass();

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        Person p5 = c1.newInstance();
        System.out.println(p5);

        System.out.println(c1.getName());
        Class<Person> c5 = (Class<Person>) Class.forName(c1.getName());
        Person p6 = c5.newInstance();
        System.out.println(p6);

        System.out.println(c1.getSuperclass());
        System.out.println(c2.getSuperclass());
        System.out.println(c3.getSuperclass());
        System.out.println(c4.getSuperclass());

        int[] a = new int[1];
        System.out.println(a.getClass());
        System.out.println(a.getClass().getSuperclass());

        for (Field f : m1.getClass().getFields()) {
            System.out.println(f);
        }
        System.out.println("");
        for (Field f : m1.getClass().getDeclaredFields()) {
            System.out.println(f);
            System.out.println("field name => " + f.getName());
            System.out.println("field type => " + f.getType());
            if (f.getName().equals("test"))
                System.out.println("field get => " + f.get(p3));

        }
        System.out.println("");
        for (Constructor c : c3.getDeclaredConstructors()) {
            System.out.println(c);
        }
        System.out.println("");
        for (Method m : c3.getDeclaredMethods()) {
            System.out.println(m);
            System.out.println("method name => " + m.getName());
            System.out.println("method invoke => " + m.invoke(p3));
        }
        printHierarchy(m1);
    }

    public static void printHierarchy(Object o) {
        printHierarchy(o.getClass());
        System.out.println("--- END ---");
    }

    private static void printHierarchy(Class c) {
        if (c != null) {
            printHierarchy(c.getSuperclass());
            System.out.println(c);
        } else {
            System.out.println("--- START ---");
        }
    }

}

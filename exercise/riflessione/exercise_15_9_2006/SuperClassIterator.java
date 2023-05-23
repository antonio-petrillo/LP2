import java.security.NoSuchAlgorithmException;
import java.util.*;

public class SuperClassIterator implements Iterator<Class<?>> {

    private Class<?> seed;

    public SuperClassIterator(Object seed) {
        this.seed = seed.getClass();
    }

    public static void main(String[] args) {
        Iterator<Class<?>> i = new SuperClassIterator(new CEO("Pujaz"));
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    @Override
    public boolean hasNext() {
        return seed != null;
    }

    @Override
    public Class<?> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Class<?> c = seed;
        seed = seed.getSuperclass();
        return c;
    }

}

class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

}

class Employee extends Person {

    public Employee(String name) {
        super(name);
    }

}

class Manager extends Employee {

    public Manager(String name) {
        super(name);
    }

}

class CEO extends Manager {

    public CEO(String name) {
        super(name);
    }

}

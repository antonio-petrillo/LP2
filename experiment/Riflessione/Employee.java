public class Employee extends Person {

    protected int salary;
    public Object justToSeeIfItIsVisibleWithClassGetMethods;

    public Employee(String name, String lastName, int salary) {
        super(name, lastName);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee: " + getName() + ", " + getLastName() + ", " + salary;
    }
}

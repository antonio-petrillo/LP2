public class Employee {

    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int newSalary) {
        salary = newSalary;
    }

    @Override
    public String toString() {
        return name + ": " + salary;
    }

}

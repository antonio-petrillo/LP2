public class Manager extends Employee {

    private int bonus;
    public final String test = "Test for get with reflection";

    public Manager(String name, String lastName, int salary, int bonus) {
        super(name, lastName, bonus);
        this.bonus = bonus;
    }

    public String methodToInvokeWithReflection() {
        return "Hu, interesting";
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Manager: " + getName() + ", " + getLastName() + ", " + salary + ", " + bonus;
    }

}

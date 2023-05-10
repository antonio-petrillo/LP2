public class Person {

    private String name;
    private String lastName;

    public Person() {
        name = "uaglio";
        lastName = "come";
    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person: " + name + ", " + lastName;
    }

}

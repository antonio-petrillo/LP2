import java.util.*;
import java.util.stream.*;

public class Example {

    public static void main(String[] args) {
        List<Employee> l = new ArrayList<>();
        l.add(new Employee("pippo", 1500));
        l.add(new Employee("sucuzzone", 500));
        l.add(new Employee("pujaz", 500));
        l.add(new Employee("papapujaz", 1500));
        l.add(new Employee("ue uaglio come", 500));
        l.add(new Employee("guattato", 500));
        l.add(new Employee("cacchinato", 1500));

        List<Employee> sorted = l.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();

        printList(sorted);

        List<Employee> filtered = l.stream()
                .filter(e -> e.getSalary() > 500)
                .toList();

        printList(filtered);

        List<Employee> increased = l.stream()
                .map(e -> new Employee(e.getName(), e.getSalary() << 1))
                .toList();

        printList(increased);
    }

    public static void printList(List<?> l) {
        l.stream().forEach(System.out::println);
        System.out.println("");
    }

}

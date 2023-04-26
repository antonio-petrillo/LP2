import java.util.*;

public class Person {

    private String name;
    private Set<Person> friends;
    private Set<Person> enemies;

    public Person(String name) {
        this.name = name;
        friends = new HashSet<>();
        enemies = new HashSet<>();
    }

    public void addFriend(Person p) {
        friends.add(p);
    }

    public void addEnemy(Person p) {
        enemies.add(p);
    }

    public Iterable<Person> contacts() {
        return new Iterable<>() {

            @Override
            public Iterator<Person> iterator() {
                return new Iterator<>() {
                    Iterator<Person> friends = Person.this.friends.iterator();
                    Iterator<Person> enemies = Person.this.enemies.iterator();

                    @Override
                    public boolean hasNext() {
                        return friends.hasNext() || enemies.hasNext();
                    }

                    @Override
                    public Person next() {
                        if (!friends.hasNext()) {
                            if (!enemies.hasNext()) {
                                throw new NoSuchElementException();
                            } else {
                                return enemies.next();
                            }
                        } else {
                            return friends.next();
                        }
                    }
                };
            }
        };
    }

    @Override
    public String toString() {
        return name;
    }

}

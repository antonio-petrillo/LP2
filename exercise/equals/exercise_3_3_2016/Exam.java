public class Exam {

    public static void main(String[] args) {

    }

}

class Unit {

    private int health;

    public Unit(int health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        Unit u = (Unit) other;
        // criteria a, is valid
        return u.health == health;
        // criteria b, is valid
        // is the same as a, but with other words.

        // criteria c, is valid
        // I can also make this final, and not implement in the subclass
        return u.health > 0 && health > 0;

        // criteria d, is not valid
        // the relation is not transitive
        // pick the case Soldier s1 == Unit u, Unit u == Soldier s2
        // it is easy to pick Unit, Soldier 1 & 2 such that s1 == u, u == s2, but s1 !=
        // s2
    }

}

class Soldier extends Unit {

    private String name;

    public Soldier(int health, String name) {
        super(health);
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        // criteria a, is valid
        if (!super.equals(other)) {
            return false;
        }
        Soldier s = (Soldier) other;
        return name.equals(s.name);
        // criteria b, is valid
        // is the same as a, but with other words.

        // criteria c, is valid
        // if Unit mark equals as final, I don't need to implement this method.
        return super.equals(other);

        // criteria d, is not valid
        // the relation is not transitive
    }

}

import java.util.*;

public class Component {

    private Type type;
    private String description;
    private Set<Component> incompatibles;

    public Component(Type type, String description) {
        this.type = type;
        this.description = description;
        incompatibles = new HashSet<>();
    }

    public Type getType() {
        return type;
    }

    public void setIncompatible(Component c) {
        incompatibles.add(c);
        c.incompatibles.add(this);
    }

    public Set<Component> getIncompatible() {
        return incompatibles;
    }

}

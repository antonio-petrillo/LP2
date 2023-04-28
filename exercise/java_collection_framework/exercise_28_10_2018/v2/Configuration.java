import java.util.*;

public class Configuration {

    private Map<Type, Component> configuration;

    public Configuration() {
        configuration = new EnumMap<>(Type.class);
    }

    public boolean add(Component component) {
        if (configuration.containsKey(component.getType())) {
            return false;
        }
        for (Component c : configuration.values()) {
            if (c.getIncompatible().contains(component)) {
                return false;
            }
        }
        configuration.put(component.getType(), component);
        return true;
    }

}

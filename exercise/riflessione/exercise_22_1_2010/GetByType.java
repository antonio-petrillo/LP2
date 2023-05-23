import java.util.*;

public class GetByType {

    public static void main(String[] args) {
        Collection<Object> c = List.of(new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                "ciao", "questa non verrá mai presa",
                new Object(), Integer.valueOf(1));
        System.out.println(GetByType.<Object>getByType(c, String.class));
        System.out.println(GetByType.<Object>getByType(c, Double.class));
        System.out.println(GetByType.<Object>getByTypeV2(c, String.class));
        System.out.println(GetByType.<Object>getByTypeV2(c, Double.class));

        c = Set.of(new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                new Object(), new Object(),
                "ciao", "questa potrebbe uscire",
                new Object(), Integer.valueOf(1));
        System.out.println(GetByType.<Object>getByType(c, String.class));
        System.out.println(GetByType.<Object>getByType(c, Double.class));
        System.out.println(GetByType.<Object>getByTypeV2(c, String.class));
        System.out.println(GetByType.<Object>getByTypeV2(c, Double.class));
    }

    public static <T> T getByType(Collection<? extends T> collection, Class<?> clazz) {
        for (T t : collection) {
            if (t.getClass() == clazz) {
                return t;
            }
        }
        return null;
    }

    public static <T> T getByTypeV2(Collection<? extends T> collection, Class<?> clazz) {
        return collection.stream()
                .unordered()
                .filter(elem -> elem.getClass() == clazz)
                .findFirst()
                .orElse(null);
    }

}

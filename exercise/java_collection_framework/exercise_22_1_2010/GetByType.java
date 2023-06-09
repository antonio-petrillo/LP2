import java.util.*;

public class GetByType {

    public static void main(String[] args) {
        List<Object> l = new LinkedList<>();
        l.add(1);
        l.add("Ciao");
        l.add(3.14159);
        l.add(new Exception());
        System.out.println(GetByType.<Object>getByTypeV1(l, Integer.class));
        System.out.println(GetByType.<Object>getByTypeV1(l, String.class));
        System.out.println(GetByType.<Object>getByTypeV1(l, Double.class));
        System.out.println(GetByType.<Object>getByTypeV1(l, Exception.class));
        System.out.println(getByTypeV2(l, Integer.class));
        System.out.println(getByTypeV2(l, String.class));
        System.out.println(getByTypeV2(l, Double.class));
        System.out.println(getByTypeV2(l, Exception.class));
    }

    public static <T> T getByTypeV3(Collection<? extends T> collection, Class<? super T> c) {
        for (T t : collection) {
            if (t.getClass() == c) {
                return t;
            }
        }
        return null;
    }

    public static <T> T getByTypeV1(Collection<? extends T> collection, Class<?> c) {
        for (T t : collection) {
            if (t.getClass() == c) {
                return t;
            }
        }
        return null;
    }

    public static Object getByTypeV2(Collection<?> collection, Class<?> c) {
        for (Object o : collection) {
            if (o.getClass() == c) {
                return o;
            }
        }
        return null;
    }

}

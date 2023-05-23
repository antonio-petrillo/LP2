public class PredictOutput {

    public static void main(String[] args) {
        Short s = 10;
        Integer a = 10;
        Double b = 11.0;
        Number aa = a;
        Number bb = b;

        // false, these are 2 different ref
        System.out.println( ((Object) s) == ((Object) a) );

        // true, aa and a point to the same Object
        System.out.println(aa == a);

        // true, since they point to the same Object then the 2 associated class are the same
        System.out.println(a.getClass().equals(aa.getClass()));

        // false, Integer.class != Double.class
        System.out.println(aa.getClass().equals(bb.getClass()));

        // true
        Object o = s;
        System.out.println(o.getClass().equals(Short.class));
    }

}

public class PredictOutput {

        public static void main(String[] args) {
                Short s = 10;
                Integer a = 10;
                Float f = new Float(10f);
                Number aa = a;
                Object o = f;

                // false
                System.out.println((Object) s == (Object) a);

                // true
                System.out.println((s + 1) == (a + 1));

                // true
                System.out.println(aa == a);

                // true
                System.out.println(a.getClass().equals(aa.getClass()));

                // true
                System.out.println(o.getClass().equals(f.getClass()));

                // false
                System.out.println(o.getClass().equals(Object.class));
        }
}

public class Driver {

    public static void main(String[] args) {
        DoubleField df = new DoubleField();
        System.out.println(df.getOne());
        System.out.println(df.getZero());
        // can't pass an int, the autoboxing to Integer isn't assignable to Double
        System.out.println(df.plus(1.0, 1.0));
        System.out.println(df.times(3.0, 4.0));

        Double[] d = { 2.0, 3.0, 1.0 };
        Polynomial<Double> p = new Polynomial<>(d, df);
        System.out.println(p.eval(3.0));
        System.out.println(p.eval(2.0));

    }

}

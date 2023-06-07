import java.util.Arrays;

public class Triangolo {

    private double sides[] = new double[3];

    public Triangolo(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("The given side don't form a triangle");
        }
        // sides[0] = a;
        // sides[1] = b;
        // sides[2] = c;
        // Arrays.sort(sides); // maybe overkill

        // for such a small array an inserction sort will be optimal
        for (int i = 1; i < 3; i++) {
            double side = sides[i];
            int j = i - 1;
            while (j >= 0 && sides[j] > side) {
                sides[j + 1] = sides[j];
                j--;
            }
            sides[j + 1] = side;
        }

    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Triangolo)) {
            return false;
        }
        Triangolo t = (Triangolo) other;
        for (int i = 0; i < 3; i++) {
            if (t.sides[i] != sides[i]) {
                return false;
            }
        }
        return true;
    }

    public double getArea() {
        double p = (sides[0] + sides[1] + sides[2]) / 2;
        return Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
    }

    public static class Rettangolo extends Triangolo {

        public Rettangolo(double catetoMinore, double catetoMaggiore) {
            super(catetoMinore, catetoMaggiore, getHypotenuse(catetoMinore, catetoMaggiore));
        }

        private static double getHypotenuse(double catetoMinore, double catetoMaggiore) {
            return Math.sqrt(catetoMinore * catetoMinore + catetoMaggiore * catetoMaggiore);
        }

    }

    public static class Isoscele extends Triangolo {

        public Isoscele(double base, double side) {
            super(base, side, side);
        }

    }

    public static void main(String[] args) {
        Triangolo x = new Triangolo(10, 20, 25);
        Triangolo y = new Triangolo.Rettangolo(5, 8);
        Triangolo z = new Triangolo.Isoscele(6, 5);

        System.out.println(x.getArea());
        System.out.println(y.getArea());
        System.out.println(z.getArea());

        Triangolo t = new Triangolo(3, 4, 5);
        Triangolo k = new Triangolo.Rettangolo(3, 4);

        System.out.println(t.equals(k));
        System.out.println(k.equals(t));
    }

}

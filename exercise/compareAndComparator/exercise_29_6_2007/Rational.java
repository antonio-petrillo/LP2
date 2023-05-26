public class Rational implements Comparable<Rational> {

    private int num, den;

    public Rational(int num, int den) {
        if (den <= 0) {
            throw new IllegalArgumentException();
        }

        int factors = gcd(num, den);
        if (factors != 1) {
            num /= factors;
            den /= factors;
        }
        this.num = num;
        this.den = den;

    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private int mcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Rational)) {
            return false;
        }
        Rational r = (Rational) other;
        return den == r.den && num == r.num;
    }

    @Override
    public int compareTo(Rational r) {
        return Integer.compare(r.den * num, r.num * den);
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    public Rational plus(Rational r) {
        int newDen = mcm(den, r.den);
        int factor1 = newDen / den;
        int factor2 = newDen / r.den;
        int newNum = num * factor1 + r.num * factor2;
        return new Rational(newNum, newDen);
    }

    public Rational times(Rational r) {
        return new Rational(num * r.num, den * r.den);
    }

    public static void main(String[] args) {
        Rational n = new Rational(2, 12); // due dodicesimi
        Rational m = new Rational(4, 15); // quattro quindicesimi
        Rational o = n.plus(m);
        Rational p = n.times(m);
        System.out.println(n);
        System.out.println(o);
        System.out.println(p);
    }

}

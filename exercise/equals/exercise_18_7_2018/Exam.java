public class Exam {
    public static void main(String[] args) {
        Fraction a = new Fraction(12,30);
        Fraction b = new ReducedFraction(12,30);
        Fraction c = new Fraction(1,4);
        Fraction d = c.times(a);

        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
        System.out.println(a.equals(b));
        System.out.println(c.times(b));
    }
}

class Fraction{

    private int num, den;

    public Fraction(int num, int den){
        this.num = num;
        this.den = den;
    }

    @Override
    public final boolean equals(Object o) {
        if(!(o instanceof Fraction)) {
            return false;
        }
        Fraction f = (Fraction) o;
        if (num > f.num){
            return num / f.num == den / f.den;
        } else {
            return f.num / num == f.den / den;
        }
    }

    public final Fraction times(Fraction f){
        return new Fraction(num * f.num, den * f.den);
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

}

class ReducedFraction extends Fraction{
    private int reducedNum, reducedDen;

    public ReducedFraction(int num, int den){
        super(num / gcd(num, den), den / gcd(num, den));
    }

    private static int gcd(int a, int b){
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

}

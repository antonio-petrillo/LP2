import java.util.*;

public class Engine {

    private double cilindrata;
    private double cavalli;

    public Engine(double cilindrata, double cavalli) {
        this.cilindrata = cilindrata;
        this.cavalli = cavalli;
    }

    @Override
    public String toString() {
        return "(" + cilindrata + " cm3, " + cavalli + " CV)";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        Engine e = (Engine) other;
        return cilindrata == e.cilindrata && cavalli == e.cavalli;
    }

    public Engine byVolume() {
        return new Engine(cilindrata, cavalli) {
            @Override
            public boolean equals(Object other) {
                if (other == null) {
                    return false;
                }
                if (getClass() != other.getClass()) {
                    return false;
                }
                Engine e = (Engine) other;
                return e.cilindrata == cilindrata;
            }

        };
    }

    public Engine byPower() {
        return new Engine(cilindrata, cavalli) {
            @Override
            public boolean equals(Object other) {
                if (other == null) {
                    return false;
                }
                if (getClass() != other.getClass()) {
                    return false;
                }
                Engine e = (Engine) other;
                return e.cavalli == cavalli;
            }
        };
    }

    // the criteria si valid
    public static Comparator<Engine> comparatorA() {
        return (a, b) -> Double.compare(a.cilindrata, b.cilindrata);
    }

    // the criteria is not valid
    // it is not trasitive and it is not consistent
    // Engine e1 = {:cilindrata 400 ...}, Engine e2 = {:cilindrata 500 ...}, Engine
    // e3 = {:cilindrata 800 ...}
    // compare(e1, e2) == 0 BUT compare(e1, e3) = -1 AND compare(e2, e3) == 0;
    // public static Comparator<Engine> comparatorB(){
    // }

    // the criteria si valid
    public static Comparator<Engine> comparatorC() {
        return (a, b) -> Double.compare(a.cavalli / a.cilindrata, b.cavalli / b.cilindrata);
    }

    // the criteria is not valid
    // e1 ={:cavalli 300 :cilindrata 800}, e2 = {:cavalli 400 :cilindrata 600}, e3 =
    // {:cavalli 200 :cilindrata 700}
    // compare(e1, e2) == -1 AND compare(e2, e3) == -1 BUT compare(e1, e3) == 0
    // public static Comparator<Engine> comparatorD() {
    // return null;
    // }

    // the criteria is not valid
    // it is not transitive
    // e1 = {:cilindrata 1200 :cavalli 300}, e2 = {:cilindrata 800 :cavalli 400}, e3
    // = {:cilindrata 500 :cavalli 200}
    // compare(e1, e2) == -1 AND compare(e2, e3) == 0 BUT compare(e1, e3) == 1
    // public static Comparator<Engine> comparatorE() {
    // return null;
    // }

    public static void main(String[] args) {
        Engine a = new Engine(1200, 69);
        Engine b = new Engine(1200, 75);
        Engine c = new Engine(1400, 75);
        System.out.println(a);
        System.out.println(a.equals(b));
        Engine aVol = a.byVolume();
        Engine bVol = b.byVolume();
        System.out.println(aVol);
        System.out.println(aVol.equals(bVol));
        System.out.println(a == aVol);
        Engine bPow = b.byPower();
        Engine cPow = c.byPower();
        System.out.println(bPow);
        System.out.println(bPow.equals(cPow));
    }

}

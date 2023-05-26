import java.util.*;

public class Sphere {

    private double x, y, z;
    private double radius;

    public Sphere(double x, double y, double z, double radius) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
    }

    public static void main(String[] args) {

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Sphere))
            return false;
        Sphere s = (Sphere) o;
        return s.radius == o.radius;
    }

    public double getVolume() {
        return 4. / 3. * Math.PI * radius * radius * radius;
    }

    public static Comparator<Sphere> getComparatorA() {
        // this criteria is valid
        return (a, b) -> Double.compare(a.getVolume(), b.getVolume());
    }

    // criteria not valid, with this def. there are no equals sphere
    // the part 1 of the contract is not valid.
    // Sphere s1, Sphere s2 AND compare(s1, s2) == -1 it is not true that
    // compare(s2, s1) == 1
    // it is still -1
    // public static Comparator<Sphere> getComparatorB() {
    // return null;
    // }

    // this criteria is not valid
    // Sphere s1, Sphere s2 AND compare(s1, s2) == 1 BUT compare(s2, s2) == 1
    // instead of -1
    // public static Comparator<Sphere> getComparatorC() {
    // return null;
    // }

    // criteria is not valid
    // it is not transitive and antisymmetric
    // Sphere s1, Sphere s2, Sphere s3 with the same radius and s1 and s3 have the
    // same radius;
    // compare(s1, s2) == 1 , compare(s2, s3) == 1, but compare(s1, s3) == 0
    // public static Comparator<Sphere> getComparatorD() {
    // return null;
    // }

}

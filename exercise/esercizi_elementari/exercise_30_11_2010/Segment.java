public class Segment implements Cloneable {

    private double x1, y1, x2, y2;

    public Segment(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Segment clone() {
        return new Segment(x1, y1, x2, y2);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Segment)) {
            return false;
        }
        Segment s = (Segment) other;
        return (x1 == s.x1 && x2 == s.x2 && y1 == s.y1 && y2 == s.y2) ||
                (x1 == s.x2 && x2 == s.x1 && y1 == s.y2 && y2 == s.y1);
    }

    private double getLength() {
        double side1 = x2 - x1;
        double side2 = y2 - y1;
        return Math.sqrt(side1 * side1 + side2 * side2);
    }

    public double getDistance() {
        return (x1 * y2 - x2 * y1) / getLength();
    }

    public static void main(String[] args) {
        Segment s1 = new Segment(0.0, -3.0, 4.0, 0.0);
        Segment s2 = new Segment(4.0, 0.0, 0.0, -3.0);
        Segment s3 = s2.clone();
        System.out.println(s1.equals(s2));
        System.out.println(s1.getDistance());
    }

}

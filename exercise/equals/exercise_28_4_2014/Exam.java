public class Exam {

    public static void main(String[] args) {
        Shape c1 = new Circle(2.0, 3.0, 1.0);
        Shape c2 = (Shape) c1.clone();
        System.out.println(c1.posX() + ", " + c1.posY());
        System.out.println(c1.width() + ", " + c1.height());
        System.out.println(c1.equals(c2));
        ((Circle) c2).setRadius(2.0);
        System.out.println(c2.posX() + ", " + c2.posY());
    }

}

abstract class Shape implements Cloneable, Comparable<Shape> {
    protected double width, height;
    protected double posX, posY;

    public Shape(double width, double height, double posX, double posY) {
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
    }

    public double posX() {
        return posX;
    }

    public double posY() {
        return posY;
    }

    public double height() {
        return height;
    }

    public double width() {
        return width;
    }

    private double getArea() {
        return width * height;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public int compareTo(Shape o) {
        return (int) (getArea() - o.getArea());
    }

}

final class Circle extends Shape {

    private double radius;
    private double centerX;
    private double centerY;

    public Circle(double posX, double posY, double radius) {
        super(2 * radius, 2 * radius, posX - radius, posY - radius);
        this.radius = radius;
        this.centerX = posX;
        this.centerY = posY;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        posX = centerX - radius;
        posY = centerY - radius;
        height = 2 * radius;
        width = 2 * radius;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Circle)) {
            return false;
        }
        Circle c = (Circle) other;

        // The relation a is not valid, it is not transitive

        // The relation b is valid
        double x = posX();
        double y = posY();
        double distance = Math.sqrt(x * x + y * y);
        double xOther = c.posX();
        double yOther = c.posY();
        double distanceOther = Math.sqrt(xOther * xOther + yOther * yOther);
        return (distance > radius && distanceOther > c.radius) ||
                (distance <= radius && distanceOther <= c.radius);

        // The relation c is not valid, it is not symmetric
    }

    @Override
    public Object clone() {
        return new Circle(centerX, centerY, radius);
    }

}

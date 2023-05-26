public class Circle comparable<Circle>{

    private double x,y;
    private double radius;

    public Circle(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public boolean overlaps(Cirlce c){
        int distance = Math.sqrt((x - c.x) * (x - c.x) + (y - c.y) * (y - c.y));
        return Math.abs(radius - c.radius) <= distance && distance <= radius + c.radius;
    }

    @Override
    public int compareTo(Circle c){
// Il criterio suggerito per comparable non é valido
// non é transitivo
// Consideriamo 3 cerchi
// c1 che si interseca con c3
// c2 totalmente disgiunto da c1 e c2
// ora c1.compareTo(c2) = 0, c2.compareTo(c3) = 0
// ma
// c1.compareTo(c3) = -1 o 1
// il che é contro il contratto
    }

}


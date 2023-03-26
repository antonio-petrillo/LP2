import java.util.Objects;

public class Exam {

}

class Box {
    private int x, y;

    public Box(int x, int y){
       this.x = x;
       this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (0 == null){
            return false;
        }
        if (o.getClass() != getClass()){
            return false;
        }
        Box b = (Box) o;
        return b.x == x && b.y == y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }


}

class ColoredBox extends Box {
    private String color;

    public ColoredBox(int x, int y, String color){
       super(x, y);
       this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)){
            return false;
        }
        ColoredBox cb = (ColoredBox) o;
        return color.equals(cb.color);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), color);
    }


}

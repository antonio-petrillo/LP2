import java.util.List;

public class Exam {

    public static void main(String[] args) {

    }

}

class Polygon {

    private static class Vertex{
        double x, y;

        @Override
        public boolean equals(Object other){
            if (other == null){
                return false;
            }
            if (getClass() != other.getClass()){
                return false;
            }
            Vertex v = (Vertex) other;
            return v.x == x && x.y == y;
        }

    }

    private List<Vertex> vertices;


    @Override
    public boolean equals(Object other){
        if (other == null){
            return false;
        }
        if (getClass() != other.getClass()){
            return false;
        }
        Polygon p = (Polygon) other;

        // criteria a, is valid
        return vertices.size() == p.vertices.size();

        // criteria b, is not valid
        // if a polygon is not a triangle, then it is not equal to itself

        // criteria c, is valid
        for (var v : vertices){
            if(!p.vertices.contains(v)) {
               return false;
            }
        }
        return true;

        // criteria d, not valid,
        // the relation is not transitive


        // criteria e, is not valid
        // if a polygon have vertices in multiple quadrant then it is not equal to itself

        // implement d, altough is not valid
        for (var v : vertices){
            if (p.vertices.contains(v)){
                return true;
            }
        }
        return false;
    }


}

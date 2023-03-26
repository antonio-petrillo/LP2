public class Exam {

}

public class Z {
    private Z other;
    private int val;

    @Override
    public boolean equals(Object other){
        // criteria a
        // not symmetric
        // is not valid

        // criteria b
        // not reflexive (pick Z(z1, 3), Z != Z)
        // is not valid

        // criteria c
        // not transitive
        // is not valid

        // criteria d
        // is valid
        if (!(other instanceof Z)){
            return false;
        }
        Z z = (Z) other;

        if (z.other != null && other != null){
            return z.val = val;
        }
        return z.other == null && other == null;

    }


}

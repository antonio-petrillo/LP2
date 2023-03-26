public class Exam {

}

class Pair<T> implements Comparable<Pair<T>> {

    private T a, b;

    @Override
    public boolean equals(Object other) {
        // criteria a, is not valid
        // not transitive
        // pick A,B,C such that:
        // A(x1, y1), B(x1, y2), C(x2, y2);
        // A == B, B == C but A != C

        // criteria b, is not valid
        // not reflexive
        // A(x, y) != A(x, y) // this case have two equals components

        // criteria c, is not valid
        // same thing, it is not reflexive
        // A(x, y), with x != y
        return false;
    }

}

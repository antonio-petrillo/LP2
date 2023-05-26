import java.util.*;

public class SetComparator {

    public static void main(String[] args) {

    }

    // the criteria is not valid
    // there is not set that compared with itself give 0
    // public static Comparator<Set<?>> comparatorA() {
    // return null;
    // }

    // the criteria is valid
    public static Comparator<Set<?>> comparatorB() {
        return (Set<?> a, Set<?> b) -> {
            var aInB = false;
            var notEquals = false;
            var bInA = false;

            for (Object o : a) {
                if (!b.contains(o)) {
                    aInB = false;
                    notEquals = true;
                    break;
                }
            }

            for (Object o : b) {
                if (!a.contains(o)) {
                    bInA = false;
                    notEquals = true;
                    break;
                }
            }

            return !notEquals ? 0 : (aInB ? -1 : (bInA ? 1 : 0));
        };
    }

    // the criteria is not valid, it is not reflexive
    // public static Comparator<Set<?>> comparatorC() {
    // return null;
    // }

    // the criteria is not valid, it is not consistent
    // s1 = HS, s2 = TS, s3 = HS, s4 = TS
    // compare(s1, s2) == 0 BUT compare(s1, s3) == 0 AND compare(s1, s4) == -1
    // public static Comparator<Set<?>> comparatorD() {
    // return null;
    // }

}

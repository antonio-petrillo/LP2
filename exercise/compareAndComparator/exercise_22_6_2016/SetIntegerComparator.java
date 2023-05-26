import java.util.*;

public class SetIntegerComparator {

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        // a.add()
    }

    // criteria not valid
    // only the empty set is equals to itself
    // public Comparator<Set<Integer>> setComparatorA(Set<Integer> s1, Set<Integer>
    // s2) {
    // return null;
    // }

    // criteria not valid
    // same thing of A, there is no set equals to itself
    // public Comparator<Set<Integer>> setComparatorB(Set<Integer> s1, Set<Integer>
    // s2) {
    // return null;
    // }

    // refuse in the contract, invert a and b in the second part of the definition
    // il criterio é valido
    public static Comparator<Set<Integer>> setComparatorC() {
        return (a, b) -> {
            boolean allNeg1 = true;
            boolean aPos1 = false;
            boolean allNeg2 = true;
            boolean allPos2 = true;
            for (var i : a) {
                if (i >= 0) {
                    allNeg1 = false;
                    aPos1 = true;
                    break;
                }
            }
            for (var i : b) {
                if (i < 0) {
                    allPos2 = false;
                }
                if (i >= 0) {
                    allNeg2 = false;
                }
                break;
            }
            return allNeg1 && !allNeg2 ? -1 : (allPos2 && (aPos1 || allNeg1) ? 1 : 0);
        };
    }

    // criteria not valid
    // a set that contains zero compared to itself give -1 instead of 0
    // public Comparator<Set<Integer>> setComparatorD(Set<Integer> s1, Set<Integer>
    // s2) {
    // return null;
    // }

    // valid criteria
    public static Comparator<Set<Integer>> setComparatorE() {
        return (a, b) -> {
            boolean containZero1 = a.stream().anyMatch(n -> n == 0);
            boolean containZero2 = b.stream().anyMatch(n -> n == 0);
            return containZero1 ^ containZero2 ? 0 : (containZero1 && !containZero2 ? -1 : 1);
        };
    }

}

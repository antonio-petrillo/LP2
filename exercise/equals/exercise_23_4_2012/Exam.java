import java.util.List;
import java.util.ArrayList;

public class Exam {

}

class Safe {
    private String secretMessage;
    private Combination combination;

    public Safe(String secret, int... keys) {
        secretMessage = secret;
        combination = new Combination(keys);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Safe)) {
            return false;
        }
        Safe s = (Safe) other;

        // criteria a, is valid
        // a safe have the same length message of itself (reflexive)
        // safe A have the same length message of B then B have the same message length
        // of A
        // A{|seq| = x}, B{|seq| = x}, C{|seq| = x} then A == B, B == C, A == C
        return s.secretMessage.length() == secretMessage.length();

        // criteria b, is not valid
        // the relation is not transitive
        // A(x1, y1), B(x1, y2), C(x2, y2), A == B, B == C, A != C

        // criteria c, is not valid
        // A Safe with combination less than 0 is not equal to itself

        // criteria d, is valid
        return s.secretMessage.length() + secretMessage.length() % 2 == 1;

        // criteria e, is not valid
        // the relation is not transitive
        // A("pujaz", 1, 2), B("maggiordomo", 4, 5), C("sucuzzone", 9, 0)
        // A == B, B == C, A != C
    }

}

class Combination {
    private List<Integer> sequence;

    public Combination(int... keys) {
        sequence = new ArrayList<>();
        for (var i : keys) {
            sequence.add(i);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Combination)) {
            return false;
        }
        Combination c = (Combination) other;
        if (c.sequence.size() != sequence.size()) {
            return false;
        }
        for (int i = 0; i < sequence.size(); i++) {
            if (c.sequence.get(i) != sequence.get(i)) {
                return false;
            }
        }
        return true;
    }

}

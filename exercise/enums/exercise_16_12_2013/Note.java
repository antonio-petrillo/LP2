import java.util.*;
import java.util.stream.*;

public enum Note {
    DO(2), RE(2), MI(1), FA(2), SOL(2), LA(2), SI(2);

    private int semitono;

    private Note(int semitono) {
        this.semitono = semitono;
    }

    public int interval(Note n) {
        if (ordinal() <= n.ordinal()) {
            return IntStream.range(ordinal(), n.ordinal())
                    .map(i -> values()[i].semitono)
                    .sum();
        }
        return -n.interval(this);
    }
}

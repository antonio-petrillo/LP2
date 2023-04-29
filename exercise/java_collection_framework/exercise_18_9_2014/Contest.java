import java.util.*;

public class Contest<T> {

    private Map<T, Integer> votes;
    private T winner;

    public Contest() {
        votes = new HashMap<>();
    }

    public void add(T t) {
        votes.put(t, 0);
        if (winner == null) {
            winner = t;
        }
    }

    public void vote(T t) {
        Integer actualVotes = votes.get(t);
        if (actualVotes != null) {
            votes.put(t, actualVotes + 1);
            if (actualVotes + 1 > votes.get(winner)) {
                winner = t;
            }
        }
    }

    public T winner() {
        return winner;
    }

    public static void main(String[] args) {
        Contest<String> c = new Contest<>();
        String r = "Red", b = "Blue", g = "Green";
        c.add(r);
        c.vote(r);
        c.add(b);
        c.add(g);
        c.vote(r);
        c.vote(b);
        System.out.println(c.winner());
    }

}

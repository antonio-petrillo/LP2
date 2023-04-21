import java.util.*;

public class Tape {

    private int pos;
    private String str;

    private final Iterable<Character> play = new Iterable<Character>() {

        @Override
        public Iterator<Character> iterator() {
            return new Iterator<Character>() {
                int iterPos = pos;

                @Override
                public boolean hasNext() {
                    return iterPos < str.length();
                }

                @Override
                public Character next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Character c = str.charAt(iterPos);
                    iterPos++;
                    return c;
                }
            };
        }
    };

    private final Iterable<Character> playBack = new Iterable<Character>() {

        @Override
        public Iterator<Character> iterator() {
            return new Iterator<Character>() {
                int iterPos = pos;

                @Override
                public boolean hasNext() {
                    return iterPos >= 0;
                }

                @Override
                public Character next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Character c = str.charAt(iterPos);
                    iterPos--;
                    return c;
                }
            };
        }
    };

    public Tape(String str) {
        this.str = str;
        this.pos = 0;
    }

    public Tape ahead() {
        pos++;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tape)) {
            return false;
        }
        Tape t = (Tape) o;
        return str.equals(t.str) && pos == t.pos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(str, pos);
    }

    public static void main(String[] args) {
        Tape t = new Tape("PollosHermanos");
        System.out.print("Play: ");
        for (var c : t.play) {
            System.out.print(c);
        }
        System.out.print("\nPlayback: ");
        for (var c : t.playBack) {
            System.out.print(c);
        }
        System.out.println("");
        t.ahead().ahead().ahead();
        System.out.print("Play after ahead x 3: ");
        for (var c : t.play) {
            System.out.print(c);
        }
        System.out.print("\nPlayback after ahead x 3: ");
        for (var c : t.playBack) {
            System.out.print(c);
        }
        System.out.println("");
    }

}

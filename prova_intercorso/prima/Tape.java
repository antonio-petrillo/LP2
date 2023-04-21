import java.util.*;

public class Tape {

    private int pos;
    private String str;

    private final Iterable<Character> play = new Iterable<>(){

            @Override
            public Iterator<Character> iterator() =
                new Iterator<Character>(){
                    int iterPos = pos;

                    @Override
                    public boolean hasNext(){
                        return iterPos < str.length();
                    }

                    @Override
                    public Character next(){
                        if(!hasNext()){
                            throw new NoSuchElementException();
                        }
                        Character c = str.charAt(startPos);
                        iterPos++;
                        return c;
                    }

                };
        };

    // ^
    // |
    // ma che cazzo ho fatto qua
    // |
    // v

    private final Iterable<Character> playBack = new Iterable<>(){

            @Override
            public Iterator<Character> iterator(){

                int iterPos = pos;

                @Override
                public boolean hasNext(){
                    return iterPos >= 0;
                }

                @Override
                public Character next(){
                    if(!hasNext()){
                        throw new NoSuchElementException();
                    }
                    Character c = str.charAt(startPos);
                    iterPos--;
                    return c;
                }

            };

        };

    // ho anche dimenticato il costruttore
    // cbepb qvb non ho ricopiato il metodo ahead

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Tape)){
            return false;
        }
        Tape t = (Tape) o;
        return str.equals(t.str) && pos == t.pos;
    }

    @Override
    public int hashcode(){
        return Objects.hashcode(str, pos);
    }

}

import java.util.*;

public class FunnyIterator implements Iterator {
    private String msg = "";

    // corretto
    public Object next() {
        if (msg.equals(""))
            msg = "ah";
        else
            msg += msg;
        return msg;
    }

    // corretta, non modifica lo stato dell'iteratore
    public boolean hasNext() {
        return msg.length() < 5;
    }

    // no rispetta, se l'iteratore non supporta il remove deve lanciare
    // UnsupportedOperationException
    public void remove() {
    }

    public void addChar() {
        msg += "b";
    }

    public static void main(String[] args) {
        Iterator i = new FunnyIterator();

        // non é parte del contratto ma l'iteratore non é usato nel modo corretto.
        // hasNext deve essere chiamato prima di next
        do {
            System.out.println(i.next());
        } while (i.hasNext());
    }
}

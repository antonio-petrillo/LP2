import java.util.*;

public class Count {

    public static void main(String[] args) {
        List<Object> l = List.of("ciao", "", Math.PI, " ", "mondo", new Object(), "!");
        System.out.println(count(l));
    }

    public static int count(List<?> l) {
        int length = 0;
        for (Object o : l) {
            if (o.getClass() == String.class) {
                String s = (String) o;
                length += s.length();
            }
        }
        return length;
    }

    // contract a
    /*
     * Il contratto a é valido anche se peculiare.
     * La precondizione viene rilassata.
     * La post condizione é ancora la stessa, deve solo rifiutare gli oggetti
     * diversi da stringhe, quindi compatibile con il contratto originale.
     */

    // contract b
    /*
     * Il contratto b non é valido.
     * Da contratto non é richiesto che le stringhe in input non siano vuote.
     * Inoltre la post condizione neanche rispetta il contratto, restituire la
     * lunghezza della stringa non equivale a restituire la somma delle stringhe
     * contenute nella lista.
     */

}

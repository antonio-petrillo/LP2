import java.util.*;

public class Driver {

    public static void main(String[] args) {
        Collection<Coin> a = Coin.convert(34); // twenty, ten, two, two
        Collection<Coin> b = Coin.convert(296);// two eur, fifty, twenty, twenty, five, one
        System.out.println(a);
        System.out.println(b);
    }

}

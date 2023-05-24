import java.util.*;

public enum Coin {
    ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50), ONE_EURO(100), TWO_EUROS(200);

    private int value;

    private Coin(int value) {
        this.value = value;
    }

    public static Collection<Coin> convert(int change) {
        // no need for dyn prog, I've always have the one.
        List<Coin> converted = new ArrayList<>();
        Coin toAdd = Coin.ONE;
        while (change > 0) {
            if (change >= 200) {
                toAdd = TWO_EUROS;
            } else if (change >= 100) {
                toAdd = ONE_EURO;
            } else if (change >= 50) {
                toAdd = FIFTY;
            } else if (change >= 20) {
                toAdd = TWENTY;
            } else if (change >= 10) {
                toAdd = TEN;
            } else if (change >= 5) {
                toAdd = FIVE;
            } else if (change >= 2) {
                toAdd = TWO;
            } else {
                toAdd = ONE;
            }
            change -= toAdd.value;
            converted.add(toAdd);
        }
        return converted;
    }

}

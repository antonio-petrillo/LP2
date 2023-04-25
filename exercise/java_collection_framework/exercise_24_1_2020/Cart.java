import java.util.*;

public class Cart {
    private double totalPrice = 0;

    private List<Product> composition = new ArrayList<>();

    public void add(Product p) {
        composition.add(p);
        totalPrice += p.getPrice();
    }

    public void remove(Product p) {
        totalPrice -= p.getPrice();
        composition.remove(p);
    }

    public double totalPrice() {
        return totalPrice;
    }
}

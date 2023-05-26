import java.util.*;

public class Product implements Comparable<Product> {

    public static final Comparator<Product> comparatorByPrice = (a, b) -> Double.compare(a.price, b.price);
    private static final SortedSet<Product> products = new TreeSet<>(Product.comparatorByPrice);
    private String descr;
    private double price;

    public Product(String descr, double price) {
        this.descr = descr;
        this.price = price;
        products.add(this);
    }

    @Override
    public int compareTo(Product p) {
        return descr.compareTo(p.descr);
    }

    public static Product getMostExpensive() {
        return products.last();
    }

    @Override
    public String toString() {
        return descr + ", " + price;
    }

    public static void main(String[] args) {
        Product a = new Product("Sale", 0.60);
        Product b = new Product("Zucchero", 0.95);
        Product c = new Product("Caffé", 2.54);
        System.out.println(Product.getMostExpensive());
        System.out.println(b.compareTo(c));
        System.out.println(Product.comparatorByPrice.compare(b, c));
    }

}

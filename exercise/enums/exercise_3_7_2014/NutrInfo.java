import java.util.*;

public class NutrInfo {
    private double calories;
    private Map<Nutrient, Double> nutrients;

    public NutrInfo(double calories) {
        this.calories = calories;
        nutrients = new EnumMap<>(Nutrient.class);
    }

    public void setNutrient(Nutrient n, double grams) {
        nutrients.put(n, grams);
    }

    public static Comparator<NutrInfo> comparatorBy(Nutrient n) {
        return (n1, n2) -> Double.compare(n1.nutrients.getOrDefault(n, -1.), n2.nutrients.getOrDefault(n, -1.));
    }

}

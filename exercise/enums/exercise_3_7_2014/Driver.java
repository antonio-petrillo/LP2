import java.util.*;

public class Driver {

    public static void main(String[] args) {
        NutrInfo x = new NutrInfo(500);
        x.setNutrient(Nutrient.FAT, 12.0);
        x.setNutrient(Nutrient.CARBO, 20.0);
        x.setNutrient(Nutrient.PROTEIN, 15.0);

        Comparator<NutrInfo> c = NutrInfo.comparatorBy(Nutrient.FAT);

        NutrInfo y = new NutrInfo(500);
        y.setNutrient(Nutrient.FAT, 18.0);
        y.setNutrient(Nutrient.CARBO, 20.0);
        y.setNutrient(Nutrient.PROTEIN, 15.0);

        NutrInfo z = new NutrInfo(500);
        z.setNutrient(Nutrient.CARBO, 20.0);
        z.setNutrient(Nutrient.PROTEIN, 15.0);

        NutrInfo k = new NutrInfo(500);
        k.setNutrient(Nutrient.CARBO, 20.0);
        k.setNutrient(Nutrient.PROTEIN, 15.0);

        System.out.println(c.compare(x, y));
        System.out.println(c.compare(x, z));
        System.out.println(c.compare(z, k));
    }

}

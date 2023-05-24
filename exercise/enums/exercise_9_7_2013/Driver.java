import java.util.*;

public class Driver {

    public static void main(String[] args) {
        Set<BloodType> types = EnumSet.noneOf(BloodType.class);
        types.add(BloodType.A);
        types.add(BloodType.B);
        types.add(BloodType.AB);
        types.add(BloodType.ZERO);
        for (var b : types) {
            for (var b2 : types) {
                System.out.println(b + " compatible with " + b2 + " ?:> " + b.canReceiveFrom(b2));
            }
            System.out.println("");
        }
    }

}

import java.util.*;

public class TestSuitEnum {

    public static void main(String[] args) {
        SuitEnum e = SuitEnum.DIAMONDS;
        System.out.println("enum := " + e);
        System.out.println("enum ordinal := " + e.ordinal());
        System.out.println("enum name := " + e.name());
        for (var s : SuitEnum.values()) {
            System.out.println(s + " is " + (s.isRed() ? "red" : "black"));
        }
        SuitEnum h = Enum.<SuitEnum>valueOf(SuitEnum.class, "HEARTS");
        System.out.println("enum := " + h);
    }

}

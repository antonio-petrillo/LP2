public class Driver {

    public static void main(String[] args) {
        System.out.println(LengthUnit.CM.convertTo(LengthUnit.INCH, 10));
        System.out.println(LengthUnit.KM.convertTo(LengthUnit.YARD, 3.5));
        System.out.println(LengthUnit.MILE.convertTo(LengthUnit.M, 6.2));
    }

}

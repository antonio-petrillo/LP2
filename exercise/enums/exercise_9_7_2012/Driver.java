public class Driver {

    public static void main(String[] args) {
        System.out.println(NumberType.SHORT.width);
        System.out.println(NumberType.INT.isAssignableTo(NumberType.FLOAT));
    }

}

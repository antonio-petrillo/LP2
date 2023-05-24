public class Driver {

    public static void main(String[] args) {
        Status a = Status.BUSY, b = Status.HIDDEN;
        System.out.println(a.isVisible());
        System.out.println(a.canContact(b));
    }

}

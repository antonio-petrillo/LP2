public class Color {

    private int red;
    private int green;
    private int blue;

    public static final Color RED = new Color(255, 0, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color BLUE = new Color(0, 0, 255);

    private Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public static Color make(int red, int green, int blue) {
        if (red == 255 && green == 0 && blue == 0) {
            return RED;
        } else if (red == 0 && green == 255 && blue == 0) {
            return GREEN;
        } else if (red == 0 && green == 0 && blue == 255) {
            return BLUE;
        }
        return new Color(red, green, blue);
    }

    @Override
    public String toString() {
        if (this == RED) {
            return "red";
        } else if (this == GREEN) {
            return "green";
        } else if (this == BLUE) {
            return "blue";
        } else {
            return "(" + red + ", " + green + ", " + blue + ")";
        }
    }

    public static void main(String[] args) {
        Color rosso = Color.RED;
        Color giallo = Color.make(255, 255, 0);
        Color verde = Color.make(0, 255, 0);
        System.out.println(rosso);
        System.out.println(giallo);
        System.out.println(verde);
        System.out.println(verde == Color.GREEN);
    }

}

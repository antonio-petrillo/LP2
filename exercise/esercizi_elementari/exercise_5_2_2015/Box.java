public class Box implements Comparable<Box> {

    private int height, width, depth;

    public Box(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public int getVolume() {
        return height * width * depth;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Box)) {
            return false;
        }
        Box b = (Box) other;
        return height == b.height && width == b.width && depth == b.width;
    }

    @Override
    public int compareTo(Box b) {
        return Integer.compare(getVolume(), b.getVolume());
    }

    public boolean fitsIn(Box b) {
        int[] sortedSides = { height, width, depth };
        int[] otherSortedSides = { b.height, b.width, b.depth };

        for (int i = 1; i < 3; i++) {
            int tmp1 = sortedSides[i];
            int tmp2 = otherSortedSides[i];
            int j = i - 1;
            while (j >= 0 && sortedSides[j] > tmp1) {
                sortedSides[j + 1] = sortedSides[j];
                j--;
            }
            sortedSides[j + 1] = tmp1;
            j = i - 1;
            while (j >= 0 && otherSortedSides[j] > tmp2) {
                otherSortedSides[j + 1] = otherSortedSides[j];
                j--;
            }
            otherSortedSides[j + 1] = tmp2;
        }

        for (int i = 0; i < 3; i++) {
            if (sortedSides[i] > otherSortedSides[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Box grande = new Box(20, 30, 40);
        Box grande2 = new Box(30, 20, 40);
        Box piccolo = new Box(10, 10, 50);

        System.out.println(grande.equals(grande2));
        System.out.println(grande.compareTo(piccolo));
        System.out.println(piccolo.fitsIn(grande));
    }

}

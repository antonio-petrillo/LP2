public class PrintBytes {

    public static String printBytes(long bytes) {
        long curr = bytes;
        long prev = -1;
        String[] units = { "bytes", "KB", "MB", "GB", "TB" };
        int index = 0;
        while (curr > 999) {
            prev = curr / 100 % 10;
            curr /= 1000;
            index++;
        }

        String extension = "";
        if (prev != -1) {
            extension = "." + Long.valueOf(prev).toString();
        }

        return curr + extension + "\t" + units[index];
    }

    public static void main(String[] args) {
        System.out.println(printBytes(123));
        System.out.println(printBytes(3000));
        System.out.println(printBytes(19199));
        System.out.println(printBytes(12500000));
        System.out.println(printBytes(710280000));
        // System.out.println(printBytes(72000538000));
    }

}

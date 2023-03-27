public class Time implements Comparable<Time> {

    private int seconds;
    private final int secondsInADay = 23 * 3600 + 59 * 60 + 60;
    public static final Time MIDDAY = new Time(12, 0, 0);
    public static final Time MIDNIGHT = new Time(0, 0, 0);

    public Time(int hours, int minutes, int seconds) {
        this.seconds = 3600 * hours + 60 * minutes + seconds;
    }

    public Time minus(Time t) {
        int diff = seconds - t.seconds;
        if (diff < 0) {
            diff = secondsInADay + diff;
        }

        int hours, minutes;

        hours = diff / 3600;
        diff %= 3600;

        minutes = diff / 60;
        diff %= 60;

        return new Time(hours, minutes, diff);
    }

    @Override
    public int compareTo(Time t) {
        return Integer.compare(seconds, t.seconds);// seconds - t.seconds;
    }

    public String toString() {

        int time = seconds, hours, minutes, seconds;

        hours = time / 3600;
        time %= 3600;

        minutes = time / 60;
        time %= 60;

        seconds = time;

        return hours + ":" + minutes + ":" + seconds;
    }

    public static void main(String[] args) {
        Time t1 = new Time(14, 35, 0);
        Time t2 = new Time(7, 10, 30);
        Time t3 = t1.minus(t2);
        System.out.println(t3);
        System.out.println(t3.compareTo(t2));
        System.out.println(t3.compareTo(Time.MIDDAY));
    }

}

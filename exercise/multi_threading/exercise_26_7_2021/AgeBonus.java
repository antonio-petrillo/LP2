public class AgeBonus extends Thread {
    private final int threshold;

    public AgeBonus(int n) {
        this.threshold = n;
    }

    // non thread safe
    // @Override
    // public void run() {
    // for (Employee e : list) {
    // if (e.getYears() > threshold) {
    // e.setSalary(e.getSalary() + 100);
    // }
    // }
    // }

    @Override
    public void run() {
        // 1
        for (Employee e : list) {
            // 2
            if (e.getYears() > threshold) {
                e.setSalary(e.getSalary() + 100);
            }
            // 3
        }
        // 4
    }

    /*
     * C
     */

}

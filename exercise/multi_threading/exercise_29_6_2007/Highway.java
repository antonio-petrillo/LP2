public class Highway {

    private int[] kilometers;
    private Object monitor = new Object();

    public Highway(int length) {
        if (length <= 0)
            throw new IllegalArgumentException();
        kilometers = new int[length];
    }

    public void progress() {
        synchronized (monitor) {
            for (int i = kilometers.length - 1; i > 0; i--) {
                kilometers[i] = kilometers[i - 1];
            }
            kilometers[0] = 0;
        }
    }

    public void insertCar(int atKilometer) {
        if (atKilometer >= kilometers.length || atKilometer < 0)
            throw new IllegalArgumentException();
        synchronized (monitor) {
            kilometers[atKilometer]++;
        }
    }

    public int nCars(int atKilometer) {
        synchronized (monitor) {
            return kilometers[atKilometer];
        }
    }

    public static void main(String[] args) {
        Highway h = new Highway(10);
        h.insertCar(3);
        h.insertCar(3);
        h.insertCar(5);
        System.out.println(h.nCars(4));
        h.progress();
        System.out.println(h.nCars(4));
    }

}

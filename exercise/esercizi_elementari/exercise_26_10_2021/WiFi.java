import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class WiFi implements Iterable<WiFi.Network> {

    private SortedSet<Network> networks;

    public WiFi() {
        networks = new TreeSet<>();
    }

    public Network addNetwork(String name, double strength) {
        Network n = new Network(name, strength);
        networks.add(n);
        return n;
    }

    public Network strongest() {
        return networks.last();
    }

    @Override
    public Iterator<Network> iterator() {
        return networks.iterator();
    }

    public class Network implements Comparable<Network> {

        private String SSID;
        private double strength;

        private Network(String SSID, double strength) {
            this.SSID = SSID;
            this.strength = strength;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof WiFi.Network)) {
                return false;
            }
            Network w = (Network) o;
            return SSID.equals(w.SSID) && strength == w.strength;
        }

        @Override
        public int compareTo(WiFi.Network o) {
            return Double.compare(strength, o.strength);
        }

        public String toString() {
            return "SSID := " + SSID + ", strenght := " + strength;
        }

        public void updateStrength(double strength) {
            networks.remove(this);
            this.strength = strength;
            networks.add(this);
        }

    }

    public static void main(String[] args) {
        WiFi manager = new WiFi();
        WiFi.Network home = manager.addNetwork("Vodafone", -40.5);
        WiFi.Network hotel = manager.addNetwork("Hotel Vesuvio", -53.05);
        WiFi.Network neighbor = manager.addNetwork("Casa Esposito", -48.95);
        neighbor.updateStrength(-39.6);
        WiFi.Network x = manager.strongest();
        System.out.println(x);

    }

}

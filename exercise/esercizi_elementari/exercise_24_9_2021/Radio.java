import java.util.SortedSet;
import java.util.TreeSet;

public class Radio {

    private SortedSet<Channel> freqs = new TreeSet<>();

    public Channel addChannel(String nome, double freq) throws ChannelAlreadyRegisteredExecption {
        Channel c = new Channel(nome, freq);
        if (!freqs.add(c)) {
            throw new ChannelAlreadyRegisteredExecption(c.toString());
        }
        return c;
    }

    // ERR
    public Channel nearest(Channel target) {
        boolean put = false;
        for (Channel c : freqs) {
            if (put) {
                return c;
            }
            if (c.equals(target)) {
                put = true;
            }
        }
        return null;
    }

    public Channel nearest(double target) {
        for (Channel c : freqs) {
            if (c.freq > target) {
                return c;
            }
        }
        return null;
    }

    public static class Channel implements Comparable<Channel> {

        private String nome;
        private double freq;

        private Channel(String nome, double freq) {
            this.nome = nome;
            this.freq = freq;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Channel)) {
                return false;
            }
            Channel c = (Channel) o;
            return freq == c.freq;
        }

        @Override
        public int compareTo(Channel o) {
            return (int) (freq - o.freq);
        }

        @Override
        public String toString() {
            return "Channel: " + nome + " at freq := " + freq;
        }

    }

    public static void main(String[] args) {
        Radio r = new Radio();
        Channel c = null;
        try {
            System.out.println(r.addChannel("Radio Maria", 83.10));
            c = r.addChannel("MGDF", 69.420);
            System.out.println(c);
            System.out.println(r.addChannel("Sucuzzone", 71.0));
            System.out.println(r.addChannel("Pujaz", 92.6));
            System.out.println(r.addChannel("Pujaz", 92.6));
        } catch (ChannelAlreadyRegisteredExecption e) {
            System.out.println(e);
        }

        System.out.println(r.nearest(c));
        System.out.println(r.nearest(71.0));

    }

}

class ChannelAlreadyRegisteredExecption extends Exception {
    private String channel;

    public ChannelAlreadyRegisteredExecption(String message) {
        this.channel = message;
    }

    @Override
    public String toString() {
        return "Channel already registered: " + channel;
    }
}

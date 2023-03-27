public class Song {
    private String name;
    private int duration;

    public Song(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Song)) {
            return false;
        }
        Song s = (Song) o;
        return name.equals(s.name) && duration == s.duration;
    }

    @Override
    public String toString() {
        return name;
    }

}

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class Playlist implements Comparable<Playlist> {

    private List<Song> songs = new LinkedList<>();
    private int totalDuration;

    public boolean add(Song s) {
        totalDuration += s.getDuration();
        return songs.add(s);
    }

    public boolean remove(Song s) {
        boolean modified = false;
        Iterator<Song> i = songs.iterator();

        while (i.hasNext()) {
            Song nextSong = i.next();
            if (nextSong.equals(s)) {
                modified = true;
                i.remove();
                totalDuration -= nextSong.getDuration();
            }
        }
        return modified;
    }

    @Override
    public int compareTo(Playlist o) {
        return totalDuration - o.totalDuration;
    }

    public static void main(String[] args) {
        Song one = new Song("One", 275), two = new Song("Two", 362);
        Playlist a = new Playlist();
        Playlist b = new Playlist();
        a.add(one);
        a.add(two);
        a.add(one);
        b.add(one);
        b.add(two);
        System.out.println(a.compareTo(b));
        a.remove(one);
        System.out.println(a.compareTo(b));
    }

}

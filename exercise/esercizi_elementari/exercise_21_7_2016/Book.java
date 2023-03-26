import java.util.Map;
import java.util.HashMap;

public class Book implements Cloneable, Comparable<Book> {
    private int chapterNumber = 1;
    private Map<Integer, Chapter> book = new HashMap<>();

    public void addChapter(String title, String content){
       book.put(chapterNumber, new Chapter(title, content));
       chapterNumber++;
    }

    public String getChapterTitle(int index){
        if (index > chapterNumber){
            return "";
        }
        return book.get(index).title;
    }

    public String getChapterContent(int index){
        if (index > chapterNumber){
            return "";
        }
        return book.get(index).content;
    }

    @Override
    public int compareTo(Book o){
        return chapterNumber - o.chapterNumber;
    }

    public Book clone(){
        Book copy = new Book();
        copy.book = book;
        copy.chapterNumber = chapterNumber;
        return copy;
    }

    public static void main(String[] args) {
        Book b = new Book();
        b.addChapter("Prefazione", "Sono passati solo pochi anni...");
        b.addChapter("Introduzione", "Un calcolatore digitale...");
        // ...
        b.addChapter("Sistemi di elaborazione", "Un calcolatore...");

        Book bb = b.clone();
        System.out.println(bb.getChapterContent(1));
        System.out.println(bb.getChapterTitle(2));
    }

    private static class Chapter {
        String title;
        String content;

        Chapter(String title, String content){
            this.title = title;
            this.content = content;
        }

        @Override
        public boolean equals(Object other){
            if(!(other instanceof Chapter)){
                return false;
            }
            Chapter c = (Chapter) other;
            return title.equals(c.title) && content.equals(c.content);
        }

    }

}

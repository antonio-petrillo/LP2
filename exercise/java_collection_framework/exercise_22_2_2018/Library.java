import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private Set<Book> published;

    public Library() {
        this.published = new HashSet<>();
    }

    public Book addBook(String title, String author) {
        Book b = new Book(title, author);
        published.add(b);
        return b;
    }

    public Set<Book> getBooksByTag(String tag) {
        return published.stream()
                .filter(b -> b.tags.contains(tag))
                .collect(Collectors.toSet());
    }

    public static class Book {
        private String author;
        private String title;
        private Set<String> tags;

        private Book(String title, String author) {
            this.author = author;
            this.title = title;
            this.tags = new HashSet<>();
        }

        public void addTag(String tag) {
            tags.add(tag);
        }

        @Override
        public String toString() {
            return title + ", by " + author;
        }

    }

    public static void main(String[] args) {
        Library casa = new Library(), ufficio = new Library();
        Library.Book b1 = casa.addBook("Esercizi␣di␣stile", "Queneau");
        b1.addTag("letteratura");
        b1.addTag("umorismo");
        Library.Book b2 = casa.addBook("Me␣parlare␣bene␣un␣giorno", "Sedaris");
        b2.addTag("umorismo");
        Library.Book b3 = ufficio.addBook("Literate␣programming", "Knuth");
        b3.addTag("programmazione");
        Set<Library.Book> humorCasa = casa.getBooksByTag("umorismo");
        System.out.println(humorCasa);
        Set<Library.Book> humorUfficio = ufficio.getBooksByTag("umorismo");
        System.out.println(humorUfficio);

    }

}

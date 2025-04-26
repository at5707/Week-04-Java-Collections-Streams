import java.util.*;
import java.util.stream.*;
class Book {
    String title, author, genre;
    double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "BookRecommendation{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
public class BookRecommender {
	public static List<List<BookRecommendation>> topBooks(List<Book> books) {
        List<BookRecommendation> filteredBooks = books.stream()
            .filter(b -> b.genre.equalsIgnoreCase("Science Fiction") && b.rating > 4.0)
            .map(b -> new BookRecommendation(b.title, b.rating))
            .sorted((a, b) -> Double.compare(b.rating, a.rating))
            .limit(10)
            .collect(Collectors.toList());

        // Pagination: 2 pages, each with 5 books
        List<List<BookRecommendation>> pages = new ArrayList<>();
        int pageSize = 5;
        for (int i = 0; i < filteredBooks.size(); i += pageSize) {
            pages.add(filteredBooks.subList(i, Math.min(i + pageSize, filteredBooks.size())));
        }
        return pages;
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
            new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
            new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.4),
            new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.1),
            new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.3),
            new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.0),
            new Book("Red Mars", "Kim Stanley Robinson", "Science Fiction", 4.2),
            new Book("The Martian", "Andy Weir", "Science Fiction", 4.6),
            new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.3),
            new Book("Old Man's War", "John Scalzi", "Science Fiction", 4.2),
            new Book("Brave New World", "Aldous Huxley", "Science Fiction", 3.9)
        );

        List<List<BookRecommendation>> pages = topBooks(books);

        for (int i = 0; i < pages.size(); i++) {
            System.out.println("Page " + (i + 1) + ":");
            pages.get(i).forEach(System.out::println);
            System.out.println();
        }
    }
}
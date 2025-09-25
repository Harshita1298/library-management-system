import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userId;
    private final String name;
    private final List<Book> issuedBooks;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void addBook(Book book) {
        issuedBooks.add(book);
    }

    public boolean removeBookById(String bookId) {
        return issuedBooks.removeIf(b -> b.getId().equals(bookId));
    }

    @Override
    public String toString() {
        return String.format("User[id=%s, name='%s', issuedBooks=%d]",
                userId, name, issuedBooks.size());
    }
}

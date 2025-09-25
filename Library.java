import java.util.*;

public class Library {
    private final Map<String, Book> books; // bookId -> Book
    private final Map<String, User> users; // userId -> User

    public Library() {
        this.books = new HashMap<>();
        this.users = new HashMap<>();
    }

    // Book management
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public Optional<Book> findBook(String bookId) {
        return Optional.ofNullable(books.get(bookId));
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("Books in library:");
        books.values().forEach(System.out::println);
    }

    // User management
    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public Optional<User> findUser(String userId) {
        return Optional.ofNullable(users.get(userId));
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        System.out.println("Registered users:");
        users.values().forEach(System.out::println);
    }

    // Issue a book to a user
    public boolean issueBook(String bookId, String userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null) {
            System.out.println("Issue failed: Book not found.");
            return false;
        }
        if (user == null) {
            System.out.println("Issue failed: User not found.");
            return false;
        }
        if (book.isIssued()) {
            System.out.println("Issue failed: Book already issued.");
            return false;
        }

        book.setIssued(true);
        user.addBook(book);
        System.out.printf("Book '%s' issued to %s.%n", book.getTitle(), user.getName());
        return true;
    }

    // Return a book from a user
    public boolean returnBook(String bookId, String userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null) {
            System.out.println("Return failed: Book not found.");
            return false;
        }
        if (user == null) {
            System.out.println("Return failed: User not found.");
            return false;
        }
        if (!book.isIssued()) {
            System.out.println("Return failed: Book was not issued.");
            return false;
        }

        boolean removed = user.removeBookById(bookId);
        if (!removed) {
            System.out.println("Return failed: This user does not have the book.");
            return false;
        }

        book.setIssued(false);
        System.out.printf("Book '%s' returned by %s.%n", book.getTitle(), user.getName());
        return true;
    }
}

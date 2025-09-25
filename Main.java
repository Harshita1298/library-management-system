public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        // Add some books
        lib.addBook(new Book("B001", "Clean Code", "Robert C. Martin"));
        lib.addBook(new Book("B002", "Introduction to Algorithms", "Cormen"));
        lib.addBook(new Book("B003", "Effective Java", "Joshua Bloch"));

        // Add some users
        lib.addUser(new User("U001", "Harshita"));
        lib.addUser(new User("U002", "Amit"));

        // List entities
        lib.listBooks();
        lib.listUsers();

        System.out.println("\n--- Issue operations ---");
        lib.issueBook("B002", "U001"); // successful
        lib.issueBook("B002", "U002"); // fail, already issued
        lib.issueBook("B010", "U001"); // fail, book not found

        System.out.println("\n--- After issue ---");
        lib.listBooks();

        System.out.println("\n--- Return operations ---");
        lib.returnBook("B002", "U002"); // fail (wrong user)
        lib.returnBook("B002", "U001"); // success

        System.out.println("\n--- After return ---");
        lib.listBooks();
    }
}

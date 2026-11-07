package libraryManagementSystem;
// Library Management System implementing GRASP principles

public class LibraryApp {

    private Library library = new Library();
    private LibrarianController controller = new LibrarianController(library);

    // Adds a book to the library catalog
    public void addBook(String bookName, String author) {
        library.addBook(bookName, author);
    }

    // Remove a book from the library catalog
    public void removeBook(String bookName) {
        library.removeBook(bookName);
    }

    // Adds a new member through the Library class
    public void addMember(String memberName) {
        library.registerMember(memberName);
    }

    // Remove a member from the library
    public void removeMember(String memberName) {
        library.removeMember(memberName);
    }

    // Borrow a book from the library
    public void borrowBook(String bookName, String memberName) {
        controller.borrowBook(bookName, memberName);
    }

    // Return a book to the library
    public void returnBook(String bookName, String memberName) {
        controller.returnBook(bookName, memberName);
    }

    // Show the available books in the library
    public void showAvailableBooks() {
        library.displayCatalog();
    }

    // Show members of in the library
    public void showMembers() {
        library.displayMembers();
    }

    // Look up a book
    public void findBook(String bookName) {
        Book book = library.findBookByTitle(bookName);

        if (book != null) {
            System.out.println(bookName + " found in catalog.");
        } else {
            System.out.println(bookName + " not found.");
        }
    }

    // Look up a member
    public void findMember(String memberName) {
        Member member = library.findMemberByName(memberName);

        if (member != null) {
            System.out.println(memberName + " found in library.");
        } else {
            System.out.println(memberName + " not found.");
        }
    }

    public static void main(String[] args) {

        LibraryApp library = new LibraryApp();

        System.out.println(" *** Library management system demo *** ");

        // Adding some books to the catalog
        System.out.println("\n *** Adding \"Dune\" to the library:");
        library.addBook("Dune", "Frank Herbert");

        System.out.println("\n *** Adding \"1984\" to the library:");
        library.addBook("1984", "George Orwell");

        System.out.println("\n *** Adding \"Moby Dick\" to the library:");
        library.addBook("Moby Dick", "Herman Melville");

        // Show available books
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        // Adding members
        System.out.println("\n *** Adding \"Alice\" to the library members");
        library.addMember("Alice");

        System.out.println("\n *** Adding \"Bob\" to the library members");
        library.addMember("Bob");

        // Show members
        System.out.println("\n *** Show all members");
        library.showMembers();

        // Borrow a book
        System.out.println("\n *** Alice borrows Dune:");
        library.borrowBook("Dune", "Alice");

        // Show available books after borrowing
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        System.out.println("\n *** Bob borrows 1984:");
        library.borrowBook("1984", "Bob");

        // Show available books after borrowing
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        System.out.println("\nBob borrows Dune:");
        library.borrowBook("Dune", "Bob");

        // Show available books after borrowing
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        // Return a book
        System.out.println("\n *** Alice returns Dune:");
        library.returnBook("Dune", "Alice");

        // Show available books after returning
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        System.out.println("\n *** Bob borrows Dune:");
        library.borrowBook("Dune", "Bob");

        // Show available books after borrowing
        System.out.println("\n *** Show all books:");
        library.showAvailableBooks();

        // Look up a book
        System.out.println("\n *** Looking up Dune:");
        library.findBook("Dune");

        // Look up a member
        System.out.println("\n *** Looking up Alice:");
        library.findMember("Alice");

        // Alice attempts to return a book she has not borrowed
        System.out.println("\n *** Alice attempts to return 1984:");
        library.returnBook("1984", "Alice");

        // Remove a book
        System.out.println("\n *** Removing Moby Dick:");
        library.removeBook("Moby Dick");

        // Remove a member
        System.out.println("\n *** Removing Alice:");
        library.removeMember("Alice");

        // Show remaining books and members
        System.out.println("\n *** Final library catalog:");
        library.showAvailableBooks();

        System.out.println("\n *** Final library members:");
        library.showMembers();

    }
}
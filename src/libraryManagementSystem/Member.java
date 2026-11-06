package libraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Member 
{

    // GRASP Principle: Information Expert and Low Coupling
    // Can borrow and return books.

    private String name;
    private List<Book> borrowedBooks;

    // Constructor
    public Member(String name) 
    {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getName() 
    {
        return name;
    }

    public List<Book> getBorrowedBooks() 
    {
        return new ArrayList<>(borrowedBooks);
    }

    // Borrow a book
    public boolean borrowBook(Book book) 
    {
        if (book != null && book.isAvailable()) 
        {
            if (book.borrowBook()) 
            {
                borrowedBooks.add(book);
                return true;
            }
        }

        return false;
    }

    // Return a book
    public boolean returnBook(Book book) 
    {
        if (book != null && borrowedBooks.contains(book)) 
        {
            borrowedBooks.remove(book);
            book.returnBook();
            return true;
        }

        return false;
    }

    // Display borrowed books
    public void displayBorrowedBooks() 
    {
        System.out.println("Books borrowed by " + name + ":");

        if (borrowedBooks.isEmpty()) 
        {
            System.out.println("No borrowed books.");
            return;
        }

        for (Book book : borrowedBooks) 
        {
            System.out.println(book);
        }
    }

    // Display member information
    @Override
    public String toString() 
    {
        return "Member: " + name +
               ", Borrowed books: " + borrowedBooks.size();
    }
}

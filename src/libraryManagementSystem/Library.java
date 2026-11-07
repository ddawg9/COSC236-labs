package libraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Library 
{
    // GRASP Principles: Creator, Controller
    // Manages the catalog of books and members.
    // Tracks which books are borrowed and available.

    private List<Book> catalog;
    private List<Member> members;
    private int nextMemberId = 1;

    // Constructor
    public Library() {
        catalog = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(String title, String author) 
    {
        Book book = new Book(title, author);
        catalog.add(book);

        System.out.println("Book added: " + title);
    }

    // Remove a book from the library
    public boolean removeBook(String title) 
    {
        Book book = findBookByTitle(title);

        if (book != null && book.isAvailable()) 
        {
            catalog.remove(book);
            System.out.println("Book removed: " + title);
            return true;
        }

        System.out.println("Book cannot be removed.");
        return false;
    }

    // Register a new member
    public void registerMember(String name) 
    {
        if (findMemberByName(name) != null) 
        {
            System.out.println("Member already exists.");
            return;
        }

        Member member = new Member("M" + nextMemberId++, name);
        members.add(member);

        System.out.println("Member registered: " + name);
    }

    // Remove a member
    public boolean removeMember(String name) 
    {
        Member member = findMemberByName(name);

        if (member != null && member.getBorrowedBooks().isEmpty()) 
        {
            members.remove(member);
            System.out.println("Member removed: " + name);
            return true;
        }

        System.out.println("Member cannot be removed.");
        return false;
    }

    // Find a book by title
    public Book findBookByTitle(String title) 
    {
        for (Book book : catalog) 
        {
            if (book.getTitle().equalsIgnoreCase(title)) 
            {
                return book;
            }
        }

        return null;
    }

    // Find a member by name
    public Member findMemberByName(String name) 
    {
        for (Member member : members) 
        {
            if (member.getName().equalsIgnoreCase(name)) 
            {
                return member;
            }
        }

        return null;
    }

    // Display all books in the catalog
    public void displayCatalog() 
    {
        System.out.println("\n--- Library Catalog ---");

        if (catalog.isEmpty()) 
        {
            System.out.println("No books in the library.");
            return;
        }

        for (Book book : catalog) 
        {
            System.out.println(book);
        }
    }

    // Display all registered members
    public void displayMembers() 
    {
        System.out.println("\n--- Library Members ---");

        if (members.isEmpty()) 
        {
            System.out.println("No registered members.");
            return;
        }

        for (Member member : members) 
        {
            System.out.println(member);
        }
    }
}
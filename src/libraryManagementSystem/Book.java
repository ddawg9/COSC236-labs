package libraryManagementSystem;
 
public class Book 
{
	// GRASP Principle: Information Expert
	// Manages its own state (available or borrowed).
	private String title;
	private String author;
	private boolean isAvailable; 

    // Constructor
    public Book(String title, String author) 
    {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters
    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() 
    {
        return author;
    }

    public boolean isAvailable() 
    {
        return isAvailable;
    }

    // Borrow book
    public boolean borrowBook() 
    {
        if (isAvailable) 
        {
            isAvailable = false;
            return true;
        }

        return false;
    }

    // Return book
    public void returnBook() 
    {
        isAvailable = true;
    }

    // Display book info
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Status: " + (isAvailable ? "Available" : "Borrowed");
    }
}

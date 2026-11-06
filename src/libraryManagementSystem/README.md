**Information Expert**

Each class is responsible for the information it knows.

Book: Manages its own availability (available or borrowed).  
Member: Keeps track of the books they have borrowed.  
Library: Searches for books and members in its collections.

**Creator**

The Library class creates Book and Member objects because it manages the collections of books and members.

For example: addBook() creates a new Book or registerMember() creates a new Member.

**Controller**

The LibrarianController handles input from a user, like borrowing and returning their books.

It passes the tasks to the correct classes instead of doing everything itself.

**Low Coupling**

Each class communicates with other classes using their public methods.

**High Cohesion**

Each class has its own responsibility:

Book: Manages book information and availability.  
Member: Manages member information and borrowed books.  
Library: Manages books and members.  
LibrarianController: Handles user requests.  
LibraryApp: Runs the application and demonstrates its functionality.


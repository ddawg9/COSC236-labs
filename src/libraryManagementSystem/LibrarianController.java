package libraryManagementSystem;

public class LibrarianController {

	// GRASP Principle: Controller
	// Handles user requests like borrowing and returning books.
	// Delegates tasks to the appropriate objects.
	
	// TODO: implement functionality of Member class
	private Library library;

	public LibrarianController(Library library) {
		this.library = library;
	}

	public boolean borrowBook(String bookTitle, String memberName) {
		Book book = library.findBookByTitle(bookTitle);
		Member member = library.findMemberByName(memberName);

		if (book == null || member == null) {
			System.out.println("Book or member not found");
			return false;
		}

		if (member.borrowBook(book)) {
			System.out.println(memberName + " borrowed " + bookTitle);
			return true;
		}

		System.out.println("Borrow request rejected.");
		return false;
	}

	public boolean returnBook(String bookTitle, String memberName) {
		Book book = library.findBookByTitle(bookTitle);
		Member member = library.findMemberByName(memberName);

		if (book == null || member == null) {
			System.out.println("Book or member not found");
			return false;
		}

		if (member.returnBook(book)) {
			System.out.println(memberName + " returned " + bookTitle);
			return true;
		}

		System.out.println("Return request rejected.");
		return false;
	}
}

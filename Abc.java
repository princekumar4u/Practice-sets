import java.util.ArrayList;
import java.util.HashMap;

// Class representing a book
class Book {
    private final String title;
    private final String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }
}

// Class representing a member
class Member {
    private String name;
    private String memberId;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }
}

// Class representing the library
class Library {
    private ArrayList<Book> books;
    private HashMap<String, Member> members;
    private HashMap<String, String> issuedBooks; // Key: Book title, Value: Member ID

    public Library() {
        books = new ArrayList<>();
        members = new HashMap<>();
        issuedBooks = new HashMap<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Method to add a member to the library
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
        System.out.println("Member added: " + member.getName());
    }

    // Method to issue a book to a member
    public void issueBook(String title, String memberId) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued()) {
                book.setIssued(true);
                issuedBooks.put(title, memberId);
                System.out.println("Book issued: " + title + " to Member ID: " + memberId);
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    // Method to return a book
    public void returnBook(String title) {
        if (issuedBooks.containsKey(title)) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    book.setIssued(false);
                    issuedBooks.remove(title);
                    System.out.println("Book returned: " + title);
                    return;
                }
            }
        }
        System.out.println("Book not found or not issued.");
    }

    // Method to search for a book
    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                String status = book.isIssued() ? "issued" : "available";
                System.out.println("Book found: " + title + " by " + book.getAuthor() + " - " + status);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Main method to test the Library Management System functionality
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("The Alchemist", "Paulo Coelho"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        // Adding members to the library
        library.addMember(new Member("Alice", "M001"));
        library.addMember(new Member("Bob", "M002"));

        // Issuing and returning books
        library.issueBook("The Alchemist","M001 ");
        library.returnBook("The Alchemist");

        // Searching for books
        library.searchBook("The Alchemist");
    }
}

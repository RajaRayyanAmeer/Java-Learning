import java.util.Scanner;

// Book class (Single Responsibility Principle - SRP)
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }
}

// Library class (Single Responsibility Principle - SRP)
class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public void displayBooks() {
        System.out.println("\nLibrary Books:");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i].getTitle() + " by " + books[i].getAuthor() +
                    " - " + (books[i].isAvailable() ? "Available" : "Not Available"));
        }
    }

    public boolean borrowBook(int index) {
        if (books[index].isAvailable()) {
            books[index].borrow();
            return true;
        }
        return false;
    }

    public boolean returnBook(int index) {
        if (!books[index].isAvailable()) {
            books[index].returnBook();
            return true;
        }
        return false;
    }

    public int getBookCount() {
        return books.length;
    }
}

// LibraryUI class (Open/Closed Principle - OCP)
class LibraryUI {
    private Library library;
    private Scanner scanner;

    public LibraryUI(Library library, Scanner scanner) {
        this.library = library;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            handleChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("\nLibrary Management System:");
        System.out.println("1. Display Books");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                library.displayBooks();
                break;
            case 2:
                handleBorrow();
                break;
            case 3:
                handleReturn();
                break;
            case 4:
                System.out.println("Exiting the system. Goodbye!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void handleBorrow() {
        library.displayBooks();
        System.out.print("Enter book number to borrow: ");
        int bookNumber = scanner.nextInt();
        if (bookNumber >= 1 && bookNumber <= library.getBookCount()) {
            if (library.borrowBook(bookNumber - 1)) {
                System.out.println("You borrowed: " + bookNumber);
            } else {
                System.out.println("Sorry, this book is not available.");
            }
        } else {
            System.out.println("Invalid book number.");
        }
    }

    private void handleReturn() {
        library.displayBooks();
        System.out.print("Enter book number to return: ");
        int bookNumber = scanner.nextInt();
        if (bookNumber >= 1 && bookNumber <= library.getBookCount()) {
            if (library.returnBook(bookNumber - 1)) {
                System.out.println("You returned: " + bookNumber);
            } else {
                System.out.println("This book is already available.");
            }
        } else {
            System.out.println("Invalid book number.");
        }
    }
}

// Main class
public class LibraryManagementSystemSOLIDPrinciples {
    public static void main(String[] args) {
        Book[] books = {
                new Book("1984", "George Orwell"),
                new Book("To Kill a Mockingbird", "Harper Lee"),
                new Book("The Great Gatsby", "F. Scott Fitzgerald")
        };

        Library library = new Library(books);
        Scanner scanner = new Scanner(System.in);
        LibraryUI libraryUI = new LibraryUI(library, scanner);

        libraryUI.start();
    }
}
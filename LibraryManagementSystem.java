import java.util.Scanner;

// Book class
class Book {
    String title;
    String author;
    boolean isAvailable;

    // Constructor
    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // Default: available
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize books
        Book[] books = new Book[3];
        books[0] = new Book("1984", "George Orwell");
        books[1] = new Book("To Kill a Mockingbird", "Harper Lee");
        books[2] = new Book("The Great Gatsby", "F. Scott Fitzgerald");

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Display Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Display books
                System.out.println("\nLibrary Books:");
                for (int i = 0; i < books.length; i++) {
                    System.out.println((i + 1) + ". " + books[i].title + " by " + books[i].author +
                            " - " + (books[i].isAvailable ? "Available" : "Not Available"));
                }
            } else if (choice == 2) {
                // Borrow book
                System.out.print("Enter book number to borrow: ");
                int bookNumber = scanner.nextInt();
                if (bookNumber >= 1 && bookNumber <= books.length) {
                    if (books[bookNumber - 1].isAvailable) {
                        books[bookNumber - 1].isAvailable = false;
                        System.out.println("You borrowed: " + books[bookNumber - 1].title);
                    } else {
                        System.out.println("Sorry, this book is not available.");
                    }
                } else {
                    System.out.println("Invalid book number.");
                }
            } else if (choice == 3) {
                // Return book
                System.out.print("Enter book number to return: ");
                int bookNumber = scanner.nextInt();
                if (bookNumber >= 1 && bookNumber <= books.length) {
                    if (!books[bookNumber - 1].isAvailable) {
                        books[bookNumber - 1].isAvailable = true;
                        System.out.println("You returned: " + books[bookNumber - 1].title);
                    } else {
                        System.out.println("This book is already available.");
                    }
                } else {
                    System.out.println("Invalid book number.");
                }
            } else if (choice == 4) {
                // Exit
                System.out.println("Exiting the system. Goodbye!");
                scanner.close();
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
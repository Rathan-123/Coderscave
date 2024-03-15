import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nAvailable: " + available;
    }
}

class User {
    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nID: " + id;
    }
}

public class LibraryManagementSystem1 {
    private static List<Book> books = new ArrayList<>();
    private static Map<Integer, User> users = new HashMap<>();
    private static int userIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Add User");
            System.out.println("4. Display Users");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    addUser(scanner);
                    break;
                case 4:
                    displayUsers();
                    break;
                case 5:
                    borrowBook(scanner);
                    break;
                case 6:
                    returnBook(scanner);
                    break;
                case 7:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        Book book = new Book(title, author);
        books.add(book);

        System.out.println("Book added successfully!");
    }

    private static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
                System.out.println("------------");
            }
        }
    }

    private static void addUser(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        User user = new User(name, userIdCounter++);
        users.put(user.getId(), user);

        System.out.println("User added successfully!");
    }

    private static void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered in the library.");
        } else {
            System.out.println("Users in the library:");
            for (User user : users.values()) {
                System.out.println(user);
                System.out.println("------------");
            }
        }
    }

    private static void borrowBook(Scanner scanner) {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (users.containsKey(userId)) {
            displayBooks();
            System.out.print("Enter book title to borrow: ");
            String bookTitle = scanner.nextLine();

            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(bookTitle) && book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book borrowed successfully!");
                    return;
                }
            }

            System.out.println("Book not available or does not exist.");
        } else {
            System.out.println("User with ID " + userId + " does not exist.");
        }
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (users.containsKey(userId)) {
            System.out.print("Enter book title to return: ");
            String bookTitle = scanner.nextLine();

            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(bookTitle) && !book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned successfully!");
                    return;
                }
            }

            System.out.println("Book not borrowed or does not exist.");
        } else {
            System.out.println("User with ID " + userId + " does not exist.");
        }
    }
}
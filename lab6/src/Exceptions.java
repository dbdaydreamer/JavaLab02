package src;
import java.util.ArrayList;
import java.util.List;

class BookAlreadyBorrowedException extends Exception {
    public BookAlreadyBorrowedException(String message) {
        super(message);
    }
}

class BookNotBorrowedException extends Exception {
    public BookNotBorrowedException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

class MaxBooksLimitException extends Exception {
    public MaxBooksLimitException(String message) {
        super(message);
    }
}

class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public void borrow() throws BookAlreadyBorrowedException {
        if (isBorrowed) {
            throw new BookAlreadyBorrowedException("Book '" + title + "' is borrowed.");
        }
        isBorrowed = true;
    }

    public void returnBook() throws BookNotBorrowedException {
        if (!isBorrowed) {
            throw new BookNotBorrowedException("Book '" + title + "' isn't borrowed.");
        }
        isBorrowed = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }
}

class User {
    private String name;
    private List<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) throws MaxBooksLimitException, BookAlreadyBorrowedException {
        if (borrowedBooks.size() >= 5) {
            throw new MaxBooksLimitException("User '" + name + "' has reached the limit.");
        }
        book.borrow();
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) throws BookNotBorrowedException {
        if (!borrowedBooks.contains(book)) {
            throw new BookNotBorrowedException("Book '" + book.getTitle() + "' wasn't taken by the user '" + name + "'.");
        }
        book.returnBook();
        borrowedBooks.remove(book);
    }

    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
}

class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void lendBook(String bookTitle, String userName) throws UserNotFoundException, BookNotFoundException, MaxBooksLimitException, BookAlreadyBorrowedException {
        User user = findUserByName(userName);
        if (user == null) {
            throw new UserNotFoundException("User '" + userName + "' not found.");
        }

        Book book = findBookByTitle(bookTitle);
        if (book == null) {
            throw new BookNotFoundException("Book '" + bookTitle + "' not found.");
        }

        user.borrowBook(book);
    }

    public void returnBook(String bookTitle, String userName) throws UserNotFoundException, BookNotFoundException, BookNotBorrowedException {
        User user = findUserByName(userName);
        if (user == null) {
            throw new UserNotFoundException("User '" + userName + "' not found.");
        }

        Book book = findBookByTitle(bookTitle);
        if (book == null) {
            throw new BookNotFoundException("Book '" + bookTitle + "' not found.");
        }

        user.returnBook(book);
    }

    private User findUserByName(String name) {
        return users.stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null);
    }

    private Book findBookByTitle(String title) {
        return books.stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(null);
    }
}

public class Exceptions {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("Java for beginners", "Mike Morrison");
        Book book2 = new Book("1984", "George Orwell");
        User user1 = new User("Evgheni");

        library.addBook(book1);
        library.addBook(book2);
        library.registerUser(user1);

        System.out.print(book1.getTitle() + ", ");
        System.out.println(book1.getAuthor());
        System.out.print(book2.getTitle() + ", ");
        System.out.println(book2.getAuthor());
        System.out.println("User: "+user1.getName());


        try {
            library.lendBook("Java for beginners", "Evgheni");
            library.lendBook("Java for beginners", "Evgheni");
        } catch (Exception e) {
            System.out.println("BookAlreadyBorrowedException: " + e.getMessage());
        }


        try {
            library.returnBook("1984", "Evgheni");
        } catch (Exception e) {
            System.out.println("BookNotBorrowedException: " + e.getMessage());
        }


        try {
            library.lendBook("1984", "NoSuchUser");
        } catch (Exception e) {
            System.out.println("UserNotFoundException: " + e.getMessage());
        }


        try {
            library.lendBook("NonexistentBook", "Evgheni");
        } catch (Exception e) {
            System.out.println("BookNotFoundException: " + e.getMessage());
        }


        try {
            for (int i = 0; i < 6; i++) {
                library.addBook(new Book("Extra" + i, "Author"));
            }
            for (int i = 0; i < 6; i++) {
                library.lendBook("Extra" + i, "Evgheni");
            }
        } catch (Exception e) {
            System.out.println("MaxBooksLimitException: " + e.getMessage());
        }
    }
}

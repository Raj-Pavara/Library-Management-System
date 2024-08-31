package org.example;

import java.util.HashMap;

public class User {

    private String name;

    private String userId;

    private HashMap<Integer, Book> books = new HashMap<>(); // Stores books borrowed by the user, with ISBN as the key.

    public User(String name) {
        this.name = name;
        this.userId = "U" + super.hashCode(); // Unique user ID start with 'U'
    }

    // get userid of user
    public String getUserId() {
        return userId;
    }

    // get username of user
    public String getUserName() {
        return name;
    }

    // get user's details
    public String getUserDetails() {
        return "User's name = " + getUserName() + ", user's Id = " + getUserId();
    }

    // borrow book to user
    public String bookBorrow(Book book) {
        if (!book.isAvailable) {
            return "Book is not available";
        }
        book.isAvailable = false;
        books.put(book.getIsbn(), book);
        book.borrower = this;
        return "Book is borrowed";
    }
}

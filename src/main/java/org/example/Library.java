package org.example;

public class Library {
    public Librarian librarian; // every library have multiple books and multiple user and one librarian

    public Library(String librarianName) {
        librarian = new Librarian(librarianName); // librarian is allocated during creation of Library class's object.
    }

    // change password of librarian
    public String changeLibrarianPassword(String priviousPassword, String newPassword) {
        return librarian.changePassword(priviousPassword, newPassword);
    }

    // change librariane name
    public String changeLibrarianName(String name) {
        return librarian.changeLibrarianName(name);
    }

    // get details of librarian
    public String getLibrarianDetail() {
        return "name = " + librarian.getLibrarianName() + ", librarian id = " + librarian.getLibrarianId();
    }
}

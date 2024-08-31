import org.example.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;

public class UserTest {

    @Test
    @DisplayName("should give warning whenever try to enter user with invalid detail")
    void testAddUserWarning(){
      Library library = new Library("raj pavara");
      Assertions.assertEquals("Invalid name",library.addUser(null));
      Assertions.assertEquals("Invalid name",library.addUser(""));
    }

    @Test
    @DisplayName("should add user if entred user's detail are valid")
    void testAddUser(){
        Library library = new Library("raj pavara");
        Assertions.assertEquals("User added",library.addUser("raj"));
        Assertions.assertEquals("User added",library.addUser("vinayak"));
        Assertions.assertEquals(2,library.users.size()); //total 2 user was added so size of users hashmap of Library class is 2
    }

    @Test
    @DisplayName("should give warning if user try to borrow book which is not available")
    void testWarningOfUnavailableBook(){
        Library library = new Library("raj pavara");
        addTestUsersAndBooks(library);
        ArrayList<String> keyUserList = getUserKeys(library);
        ArrayList<Integer> keyBookList = getBookKeys(library);
        library.bookBorrow(keyBookList.get(0),keyUserList.get(0));
        Assertions.assertEquals("Book is not available",library.bookBorrow(keyBookList.get(0),keyUserList.get(1))); //try to borrow book which is already borrowed
    }

    @Test
    @DisplayName("should give warning if user try to borrow book which is not exists in library")
    void testWarningOfNotExistsBook(){
        Library library = new Library("raj pavara");
        addTestUsersAndBooks(library);
        ArrayList<String> keyUserList = getUserKeys(library);
        ArrayList<Integer> keyBookList = getBookKeys(library);
        Assertions.assertEquals("book is not exists",library.bookBorrow(keyBookList.get(0)+5,keyUserList.get(1))); //try to borrow book which is not exists keyBookList.get(0) + 5 key is not exists in bookKey
    }

    @Test
    @DisplayName("should borrow a book to user if book is available and exists")
    void borrowBook(){
        Library library = new Library("raj pavara");
        addTestUsersAndBooks(library);
        ArrayList<String> keyUserList = getUserKeys(library);
        ArrayList<Integer> keyBookList = getBookKeys(library);
        Assertions.assertEquals("Book is borrowed",library.bookBorrow(keyBookList.get(0),keyUserList.get(1)));
        Assertions.assertEquals("Book is borrowed",library.bookBorrow(keyBookList.get(1),keyUserList.get(0)));
    }


    //add test user's and book
    void addTestUsersAndBooks(Library library){
        library.addBook("Around the World in Eighty Days","Jules Verne",1872,"21028011");
        library.addBook("The Intelligent Investor","Benjamin Graham",1949,"21028011");
        library.addUser("raj");
        library.addUser("parth");
    }

    //get list of keys of user hashmap of Library class.
    ArrayList<String> getUserKeys(Library library){
        Set<String> keys = library.users.keySet();
        ArrayList<String> keyList = new ArrayList<>();
        for(String key : keys){
            keyList.add(key);
        }
        return keyList;
    }

    //get list of keys of books hashmap of Library class.
    ArrayList<Integer> getBookKeys(Library library){
        Set<Integer> keys = library.books.keySet();
        ArrayList<Integer> keyList = new ArrayList<>();
        for(Integer key : keys){
            keyList.add(key);
        }
        return keyList;
    }
}

import org.example.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}

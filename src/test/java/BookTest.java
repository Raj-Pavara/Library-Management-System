import org.example.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    @DisplayName("should give warning whenever user try to enter book with invalid detail")
    void testAddBookWarning(){
        Library library = new Library("raj pavara");
        Assertions.assertEquals("wrong password entered",library.addBook("Around the World in Eighty Days","Jules Verne",1872,"210280116"));
        Assertions.assertEquals( "wrong auther",library.addBook("Around the World in Eighty Days","",1872,"21028011"));
        Assertions.assertEquals("wrong auther",library.addBook("Around the World in Eighty Days",null,1872,"21028011"));
        Assertions.assertEquals("wrong title",library.addBook("","Jules Verne",1872,"21028011"));
        Assertions.assertEquals("wrong title",library.addBook(null,"Jules Verne",1872,"21028011"));
        Assertions.assertEquals("wrong publicationyear",library.addBook("Around the World in Eighty Days","Jules Verne",-300,"21028011"));
        Assertions.assertEquals("wrong publicationyear",library.addBook("Around the World in Eighty Days","Jules Verne",2055,"21028011"));
    }

    @Test
    @DisplayName("should add book whenever enter book with valid details")
    void testAddBook(){
        Library library = new Library("raj pavara");
        Assertions.assertEquals( "book added",library.addBook("Around the World in Eighty Days","Jules Verne",1872,"21028011"));
        library.addBook("The Intelligent Investor","Benjamin Graham",1949,"21028011");
        Assertions.assertEquals(2,library.books.size()); //2 book was added so books hashmap of Library class has should be 2 size.
    }
}

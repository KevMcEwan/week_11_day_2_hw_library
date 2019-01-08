import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {
    Borrower borrower;
    Book book1;
    Book book2;
    Book book3;
    Book book4;
    Book book5;

    @Before
    public void before() {
        borrower = new Borrower("Kevin");
        book1 = new Book("Harry Potter", "JK Rowling", "Fantasy");
        book2 = new Book("Space", "Stephen Baxter", "Sci-fi");
        book3 = new Book("A Brief History of Time", "Stephen Hawking", "Non-fiction");
        book4 = new Book("Different Seasons", "Stephen King", "Horror");
        book5 = new Book("A Scandal In Bohemia", "Arthur Conan Doyle", "Crime");
    }

    @Test
    public void checkNoBooksInCollection(){
        assertEquals(0, borrower.countBooksInCollection());
    }

    @Test
    public void addBookToCollection(){
        borrower.addBookToCollection(book1);
        assertEquals(1, borrower.countBooksInCollection());
    }


}

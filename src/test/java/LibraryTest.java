import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    Library library;
    Borrower borrower;
    Book book1;
    Book book2;
    Book book3;
    Book book4;
    Book book5;

    @Before
    public void before(){
        library = new Library(4);
        borrower = new Borrower("Kevin");
        book1 = new Book("Harry Potter", "JK Rowling", "Fantasy");
        book2 = new Book("Space", "Stephen Baxter", "Sci-fi" );
        book3 = new Book("A Brief History of Time", "Stephen Hawking", "Non-fiction");
        book4 = new Book("Different Seasons", "Stephen King", "Horror");
        book5 = new Book("A Scandal In Bohemia", "Arthur Conan Doyle", "Crime");
    }

    @Test
    public void checkNoBooksInStock(){
        assertEquals(0, library.countBooksInStock());
    }
    @Test
    public void canCountBooksInStock(){
        library.addBookToStock(book1);
        library.addBookToStock(book2);
        library.addBookToStock(book3);
        assertEquals(3, library.countBooksInStock());
    }

    @Test
    public void doNotAddIfCapacityReached(){
        library.addBookToStock(book1);
        library.addBookToStock(book2);
        library.addBookToStock(book3);
        library.addBookToStock(book4);
        assertEquals(4, library.countBooksInStock());
        library.addBookToStock(book5);
        assertEquals(4, library.countBooksInStock());
    }

    @Test
    public void canRemoveBookFromStock(){
        library.addBookToStock(book1);
        library.addBookToStock(book2);
        library.addBookToStock(book3);
        library.addBookToStock(book4);
        assertEquals(4, library.countBooksInStock());
        library.removeBookFromStock(book1);
        assertEquals(3,library.countBooksInStock());
    }

    @Test
    public void canCheckBookIsInStock(){
        library.addBookToStock(book1);
        library.addBookToStock(book2);
        library.addBookToStock(book3);
        library.addBookToStock(book4);
        assertEquals(4, library.countBooksInStock());
        assertEquals(true, library.checkBookIsInStock(book1) );
    }

    @Test
    public void lendBookToBorrower(){
        library.addBookToStock(book1);
        library.addBookToStock(book2);
        library.addBookToStock(book3);
        library.addBookToStock(book4);
        assertEquals(4, library.countBooksInStock());
        Book loanedBook = library.removeBookFromStock(book1);
        borrower.addBookToCollection(loanedBook);
        assertEquals(false, library.checkBookIsInStock(book1));
        assertEquals(1, borrower.countBooksInCollection());

    }
}

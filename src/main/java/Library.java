import java.util.ArrayList;

public class Library {
    private int capacity;
    private ArrayList<Book> stock;

    public Library(int capacity) {
        this.capacity = capacity;
        this.stock = new ArrayList<Book>();
    }

    public void addBookToStock(Book book){
        if (this.stock.size() < this.capacity) {
            this.stock.add(book);
        }
    }

    public int countBooksInStock(){
        return stock.size();
    }

    public Book removeBookFromStock(Book book){
        this.stock.remove(book);
        return book;
    }

    public boolean checkBookIsInStock(Book book){
        return this.stock.contains(book);
    }
}



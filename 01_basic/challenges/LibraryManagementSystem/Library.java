package challenges.LibraryManagementSystem;
import java.util.List;

public class Library {
    private List<Book> books;

    void addBook(Book book){

    }

    public static void main(String[] args){
        Book cleanCode = new Book("Clean Code", "Robert Martin", "1", true);
        Book effectiveJava = new Book("Effective Java", "Joshua Bloch", "2", false);
        Book headFirstJava = new Book("Head First Java", "Kathy Sierra", "3", true);
    }
}

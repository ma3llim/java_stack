package challenges.LibraryManagementSystem;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book){
        books.add(book);
    }

    void removeBook(Book book){
        books.remove(book);
    }

    ArrayList<Book> searchByTitle(String title){
        ArrayList<Book> booksSearchByTitle = new ArrayList<>();

        for(Book book: books){
            if(book.getTitle().equals(title)){
                booksSearchByTitle.add(book);
            }
        }
        return booksSearchByTitle;
    }

    ArrayList<Book> searchByAuthor(String author){
        ArrayList<Book> booksSearchByAuthor = new ArrayList<>();

        for(Book book: books){
            if(book.getAuthor().equals(author)){
                booksSearchByAuthor.add(book);
            }
        }
        return booksSearchByAuthor;
    }

    public static void main(String[] args){
        Book cleanCode = new Book("Clean Code", "Robert Martin", "1", true);
        Book effectiveJava = new Book("Effective Java", "Joshua Bloch", "2", false);
        Book headFirstJava = new Book("Head First Java", "Kathy Sierra", "3", true);
    }
}

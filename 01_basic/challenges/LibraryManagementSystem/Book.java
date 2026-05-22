package challenges.LibraryManagementSystem;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private Boolean isAvailable;

    Book(String title, String author, String isbn, Boolean isAvailable){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    String displayInfo(){
        return "Book{" +
                "title='" + this.title + '\'' +
                ", author='" + this.author + '\'' +
                ", isbn='" + this.isbn + '\'' +
                ", isAvailable=" + this.isAvailable +
                '}';
    }
}

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    void borrow(String isbn){
        if(this.isbn.equals(isbn)){
            if(!this.isAvailable){
                this.isAvailable = false;
                System.out.println("This" + this.title + "Is Now Allocated to you");
            }else {
                System.out.println("This" + this.title + "Is Already Borrow.");
            }
        }
        else {
            System.out.println("ISBN does not match");
        }
    }

    void returnBook(String isbn){
        if(this.isbn.equals(isbn)){
            this.isAvailable = true;
            System.out.println("This" + this.title + "Is Return Back");
        }
        else {
            System.out.println("ISBN does not match");
        }
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

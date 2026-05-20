package challenges.basic;

public class Book {
    private String title;
    private String author;
    private int price;

    Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    String getDetails(){
        return "Book{" +
                "title='" + this.title + '\'' +
                ", author='" + this.author + '\'' +
                ", price=" + this.price +
                '}';
    }

    public static void main(String[] args){
        Book newBook = new Book("Java", "John", 990);
        System.out.println(newBook.getDetails());
    }
}


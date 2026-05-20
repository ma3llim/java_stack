package challenges.basic;

//Product — name, price, quantity, getTotalValue()
public class Product {
    private String name;
    private int price;
    private int quantity;

    Product(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    String getTotalValues(){
        return "Product{" +
                "name='" + this.name + '\'' +
                ", price=" + this.price +
                ", quantity=" + this.quantity +
                '}';
    }

    public static void main(String[] args){
        Product product = new Product("Pen Tablet", 3600, 6);
        System.out.println(product.getTotalValues());
    }
}

public class Dog extends Animal {
    String food;

    public Dog(String name) {
        this.food = "Apple";
        System.err.println("Dog is initialized");
        super(name);
    }

    public static void main(String[] args) {
        new Dog("Tommy");
    }
}

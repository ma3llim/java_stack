@FunctionalInterface
interface A {
    void show(int num);
}

public class Lambda {
    public static void main(String[] args) {
        A obj = num -> System.out.println("User Input Number Is " + num);
        obj.show(10);
    }
}

package practise_files;

@FunctionalInterface
interface A {
    void show();
}

public class functionalInterface {
    public static void main(String[] args) {
        A obj = new A() {
            public void show() {
                System.out.println("IN show");
            }
        };
        obj.show();
    }
}

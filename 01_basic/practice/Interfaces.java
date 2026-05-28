package practice;

interface A {
    String name = "Mohd Sameer"; // final and static

    void show();

    void config();
}

interface X {
    void run();
}

interface Y extends A, X {

}

class B implements Y {
    public void show() {
        System.out.println("In Show Method");
    }

    public void config() {
        System.out.println("In config Method");
    }

    public void run() {
        System.out.println("In run Method");
    }
}

public class Interfaces {
    public static void main(String[] args) {
        A obj;
        obj = new B();
        obj.show();
        obj.config();
        System.out.println(A.name);
    }
}

package practice;

interface Computer {
    void code();
}

class Desktop implements Computer {
    public void code() {
        System.out.println("Code, Complie, Run: Faster");
    }
}

class Laptop implements Computer {
    public void code() {
        System.out.println("Code, Complie, Run");
    }

}

class Developer {
    public void devApp(Computer device) {
        device.code();
    }
}

public class NeedofInterface {
    public static void main(String[] args) {
        Computer desktop = new Desktop();
        Computer laptop = new Laptop();
        Developer newDev = new Developer();

        newDev.devApp(desktop);
        newDev.devApp(laptop);
    }
}

package Interface;

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

interface Runnable {
    void run();
}

class DuckFinal implements Flyable, Swimmable, Runnable {
    private String name;
    DuckFinal(String name){
        this.name = name;
    }

    @Override
    public void fly(){
        System.out.println(name + "is a Flyable");
    }

    @Override
    public void swim(){
        System.out.println(name + "is a Swimmable");
    }

    @Override
    public void run(){
        System.out.println(name + "is a Runnable");
    }
}
public class Duck {
    static void main(String[] args) {
        DuckFinal duck = new DuckFinal("Joy");
        duck.fly();
        duck.swim();
        duck.run();
    }
}

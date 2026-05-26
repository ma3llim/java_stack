package InheritancePolymorphism.Abstract;

abstract class AnimalAbstract {
    protected String name;

    AnimalAbstract(String name){
        this.name = name;
    }

    void eat(){
        System.out.println(name + " is eating");
    }

    abstract void makeSound();
}

class Dog extends AnimalAbstract {
    Dog(String name){
        super(name);
    }

    @Override
    void makeSound(){
        System.out.println("Bark");
    }
}

class Cat extends AnimalAbstract {
    Cat(String name){
        super(name);
    }

    @Override
    void makeSound(){
        System.out.println("Meow");
    }
}

public class Animal {
    static void main(String[] args) {
        AnimalAbstract dog = new Dog("Tommy");
        AnimalAbstract cat = new Cat("Kitty");

        dog.eat();
        dog.makeSound();
        cat.eat();
        cat.makeSound();
    }
}
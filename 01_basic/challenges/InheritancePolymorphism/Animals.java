package challenges.InheritancePolymorphism;

// Write: Animal → Dog, Cat, Bird — each overrides makeSound()
class Animal {
    void makeSound() {
        System.out.println("Some Animal Sound");
    }
}

class Dog extends AnimalRef {
    @Override
    void makeSound(){
        System.out.println("Bark");
    }
}

class Cat extends AnimalRef {
    @Override
    void makeSound(){
        System.out.println("Meow");
    }
}

class Bird extends AnimalRef {
    @Override
    void makeSound(){
        System.out.println("Tweet");
    }
}

public class Animals {
    public static void main(String[] args){
        Dog dog = new Dog();
        Cat cat = new Cat();
        Bird bird = new Bird();

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}

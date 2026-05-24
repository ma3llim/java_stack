package challenges.InheritancePolymorphism;

class AnimalRef {
    void makeSound(){
        System.out.println("Animal Sound");
    }

    void eat(){
        System.out.println("Animal is eating");
    }
}

class DogRef extends AnimalRef {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }

    void bark() {
        System.out.println("Dog is barking");
    }
}

public class ReferenceObjectType {
    public static void main(String[] args){
        AnimalRef a = new DogRef();
        a.eat();
        a.makeSound();
        // a.bark(); // compile error
    }
}

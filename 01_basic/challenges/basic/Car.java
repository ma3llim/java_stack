package challenges.basic;

public class Car {
    private String brand;
    private String model;
    private int speed;

    Car(String brand, String model, int speed){
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    void accelerate(int speed){
        this.speed+=speed;
        System.out.println("Current Speed " + this.speed);
    }

    void brake(int speed){
        this.speed-=speed;
        System.out.println("Current Speed " + this.speed);
    }

    public static void main(String[] args){
        Car objCard = new Car("Audi", "A8", 10);
        objCard.accelerate(45);
        objCard.brake(43);
    }
}

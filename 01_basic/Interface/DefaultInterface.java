package Interface;

interface Vehicle {
    void start();

    default void stop(){
        System.out.println("Vehicle Stopped");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
}
public class DefaultInterface {
    static void main(String[] args) {
        Car car = new Car();

        car.start();
        car.stop();
    }
}

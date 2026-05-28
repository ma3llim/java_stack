package practice;

// toString Methods
class Car {
    int noOfWheels, noOfDoors;
    float maxSpeed;
    String name, modelNumber, company;

    public Car(int noOfWheels, int noOfDoors, float maxSpeed, String name, String modelNumber, String company) {
        this.noOfWheels = noOfWheels;
        this.noOfDoors = noOfDoors;
        this.maxSpeed = maxSpeed;
        this.name = name;
        this.modelNumber = modelNumber;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Car Details:\n" +
                "Company: " + company + "\n" +
                "Name: " + name + "\n" +
                "Model Number: " + modelNumber + "\n" +
                "Wheels: " + noOfWheels + "\n" +
                "Doors: " + noOfDoors + "\n" +
                "Max Speed: " + maxSpeed + " km/h";
    }
}

public class toString {
    public static void main(String[] args) {
        Car swift = new Car(4, 4, 120, "Swift", "sw879", "Maruti");
        System.out.println(swift.toString());
    }
}

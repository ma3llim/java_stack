package challenges.challenge1.example.utils;

import challenges.challenge1.example.geometry.Circle;
import challenges.challenge1.example.geometry.Rectangle;

public class Challenge {
    public static void main(String[] args){
        Circle circleArea = new Circle(4);
        Rectangle rectangleArea = new Rectangle(4.700000000,5.9000);

        System.out.println("Area of a circle: " + circleArea.getCircleArea());
        System.out.println("Area of a rectangle: " + rectangleArea.getRectangleArea());
    }
}

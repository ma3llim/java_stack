package challenges.challenge1.example.geometry;

public class Rectangle {
    private double length, width;

    public  Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double getRectangleArea(){
        return (long)(length  * width * 100) / 100.0;
    }
}

package challenges.challenge1.example.geometry;

public class Circle {
    private  double radius;

    public  Circle(double radius){
        this.radius = radius;
    }

    public double getCircleArea (){
        double area = Math.PI * radius * radius;
        return Math.round(area * 100.0) / 100.0;
    }
}

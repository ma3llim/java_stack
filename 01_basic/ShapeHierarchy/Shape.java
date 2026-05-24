package ShapeHierarchy;

class Shapes{
    String color;

    Shapes(String color){
        this.color = color;
    }

    String getColor(){
        return this.color;
    }

    double area(){
        return 0;
    }

    double perimeter(){
        return 0;
    }
}

class Circle extends Shapes {
    double radius;

    Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }

    @Override
    double area(){
        return Math.PI * radius*radius;
    }

    @Override
    double perimeter(){
        return 2 * Math.PI * Math.PI;
    }
}

public class Shape {
    public static void main(String[] args){

    }
}

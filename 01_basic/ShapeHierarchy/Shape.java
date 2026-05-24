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

class Rectangle extends Shapes {
    double length;
    double width;

    Rectangle(String color, double length, double width){
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    double area(){
        return length * width;
    }

    @Override
    double perimeter(){
        return 2 * (length+width);
    }
}

// Triangle → area() = ½×b×h
class Triangle extends Shapes {
    double base;
    double height;

    Triangle(String color, double base, double height){
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    double area(){
        return 0.5 * base * height;
    }
}

public class Shape {
    public static void main(String[] args){

    }
}

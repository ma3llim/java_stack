public class StaticAndFinal {
    public static void main(String[] args){
        Student2 s1 = new Student2("Aditiya", 28, 1);
        Student2 s2 = new Student2("Sabith", 25, 2);
        Random r1 = new Random();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(r1.PI);
    }


}

// Static
class Student2 {
    String name;
    int age;
    int rollNumber;
    static String college;

    Student2(String name, int age, int rollNumber) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "{\n"
                + "\t\"name\": \"" + name + "\",\n"
                + "\t\"age\": " + age + ",\n"
                + "\t\"rollNumber\": " + rollNumber + ",\n"
                + "\t\"college\": \"" + college + "\"\n"
                + "}";
    }

    // Static block
    static {
        college = "IIT Guwahati";
    }
}

// Final
class Random {
    final double PI;

    Random(){
        this.PI = 3.14;
    }
}
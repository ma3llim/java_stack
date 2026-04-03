public class ChainingConstructors {
    public static void main(String[] args){
        StudentDemo s1 =  new StudentDemo();
        StudentDemo s2 =  new StudentDemo("Sameer");
        StudentDemo s3 =  new StudentDemo("Sameer", 21);
        StudentDemo s4 =  new StudentDemo("Sameer", 21, 101);
        StudentDemo s5 =  new StudentDemo("Sameer", 21, 101, "Tier-3");

        System.out.println(s5);
    }
}

class StudentDemo {
    String name;
    int age;
    int rollNumber;
    String college;

    public StudentDemo(){}

    public StudentDemo(String name){
        this(name, 0,0, "");
    }

    public StudentDemo(String name, int age){
        this(name, age,0, "");
    }

    public StudentDemo(String name, int age, int rollNumber){
        this(name, age, rollNumber, "");
    }

    public StudentDemo(String name, int age, int rollNumber, String college) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.college = college;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rollNumber=" + rollNumber +
                ", college='" + college + '\'' +
                '}';
    }
}
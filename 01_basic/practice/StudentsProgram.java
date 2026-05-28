package practice;

class StudentClass {
    private final String name;
    private final int age;
    private final char grade;

    StudentClass(String name, int age, char grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    void display() {
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Grade : " + grade);
        System.out.println();
    }
}

public class StudentsProgram {
    public static void main(String[] args){
        StudentClass studentClass1 = new StudentClass("John", 90, 'A');
        studentClass1.display();
    }
}

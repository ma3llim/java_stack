package ExecptionHandling.Student;

import ExecptionHandling.exceptions.InvalidAgeException;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) throws InvalidAgeException {
        this.id = id;
        this.name = name;
        if(age < 18){
            throw new InvalidAgeException("Age must be 18 or above");
        }else {
            this.age = age;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeException {
        if(age < 18){
            throw new InvalidAgeException("Age must be 18 or above");
        }
        this.age = age;
    }
}

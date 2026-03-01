package challenges;

class EmployeClass {
    private String name;
    private int age;
    private double salary;

    public EmployeClass(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeDetails() {
        return "Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}

public class Employee {
    public static void main(String[] args){
        EmployeClass emp = new EmployeClass("Mohd Sameer", 21, 24000);
        System.out.println("Get Employee Details" + emp.getEmployeeDetails());
    }
}

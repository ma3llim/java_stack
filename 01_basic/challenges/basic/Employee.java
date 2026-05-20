package challenges.basic;

public class Employee {
    private String name;
    private int salary;
    private String department;

    Employee(String name, int salary,String department){
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    int getSalary(){
        return this.salary;
    }

    public static void main(String[] args){
        Employee employee = new Employee("Sameer", 35000, "Front End Development");

        System.out.println(employee.getSalary());
    }
}

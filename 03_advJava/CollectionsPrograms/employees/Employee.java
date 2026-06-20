package CollectionsPrograms.employees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee implements Comparable<Employee> {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other){
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + salary;
    }

    public static void main(String[] args){
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(103,"Rahul",60000));
        employees.add(new Employee(101,"Sameer",50000));
        employees.add(new Employee(102,"Amit",70000));

        // Comparable (ID)
        Collections.sort(employees);
        // Comparator (SALARY)
        Collections.sort(employees, (e1, e2) -> Double.compare(e1.salary, e2.salary));
        System.out.println(employees);

    }
}

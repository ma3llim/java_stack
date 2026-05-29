package practice;

import java.util.HashSet;
import java.util.Objects;

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // toString()
    @Override
    public String toString() {
        return """
                Person
                    Name : %s
                    Age  : %d
                """.formatted(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Person)) {
            return false;
        }
        // downcasting
        Person person = (Person) obj;

        // logical comparison
        return this.name.equals(person.name)
                && this.age == person.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}


public class Students {
    public static void main(String[] args) {
        Person p1 = new Person("Sameer", 21);
        Person p2 = new Person("Sameer", 21);
        Person p3 = new Person("Rahul", 25);

        System.out.println(p1);

        // equals()
        System.out.println("p1 equals p2 : " + p1.equals(p2));
        System.out.println("p1 equals p3 : " + p1.equals(p3));

        // hashCode()
        System.out.println("p1 hashCode : " + p1.hashCode());
        System.out.println("p2 hashCode : " + p2.hashCode());

        // HashSet test
        HashSet<Person> people = new HashSet<>();

        people.add(p1);
        people.add(p2);
        people.add(p3);

        System.out.println("HashSet Size : " + people.size());

        // instanceof
        if (p1 instanceof Person) {
            System.out.println("p1 is Person object");
        }
    }
}

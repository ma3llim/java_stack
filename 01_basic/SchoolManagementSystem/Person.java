package SchoolManagementSystem;

import java.util.Objects;

public abstract class Person {
    protected int Id;
    protected String name;
    protected int age;

    @Override
    public String toString() {
        return "Person{id=" + Id + ", name='" + name + "', age=" + age + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Id == person.Id && age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, age);
    }
}

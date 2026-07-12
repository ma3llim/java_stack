package proxies.classes;

public class Man implements Person {
    private String name;
    private int age;
    private String city;
    private String state;

    public Man(String name, int age, String city, String state) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.state = state;
    }

    @Override
    public void introduce(String name) {
        System.out.println("My Name is " + this.name);
    }

    @Override
    public void sayAge(int age) {
        System.out.println("I am " + this.age + "Year Old");
    }

    @Override
    public void sayWhereFrom(String city, String state) {
        System.out.println("I am From" + this.city + ", " + this.state);
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

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

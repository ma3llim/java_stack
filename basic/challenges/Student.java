class Student {
    String name, rollNumber, house;
    int age;

    public Student(String name, String rollNumber, String house, int age) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.house = house;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student Details: \n Name: " + name + "Roll Number: " + rollNumber + "House: " + house + "Age: " + age;
    }
}

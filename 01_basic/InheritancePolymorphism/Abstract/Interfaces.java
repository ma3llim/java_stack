package InheritancePolymorphism.Abstract;

interface Payable {
    void pay();
}

class Employee implements Payable {
    @Override
    public void pay(){
        System.out.println("Employee salary paid");
    }
}

class Contractor implements Payable {
    @Override
    public void pay(){
        System.out.println("Contractor payment paid");
    }
}

public class Interfaces {
    static void main(String[] args) {
        Payable employee = new Employee();
        Payable contractor = new Contractor();

        employee.pay();
        contractor.pay();
    }
}

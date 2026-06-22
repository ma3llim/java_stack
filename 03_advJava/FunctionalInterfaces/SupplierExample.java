package FunctionalInterfaces;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args){
        Supplier<String> greeting = () -> "Welcome to java";

        System.out.println(greeting.get());
    }
}

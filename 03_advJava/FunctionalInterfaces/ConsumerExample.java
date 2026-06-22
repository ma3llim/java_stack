package FunctionalInterfaces;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args){
        Consumer<String> printName = name -> System.out.println(name);

        printName.accept("Sameer");
    }
}

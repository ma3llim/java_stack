package Generic;

import java.util.List;

public class GenericMethods {
    public static <T> T getFirst(List<T> list){
        return list.get(0);
    }
    public static void main(String[] args){
        String name = getFirst(List.of("Sameer", "Rahul"));
        Integer number = getFirst(List.of(10, 20, 30));

        System.out.println(name);
        System.out.println(number);
    }
}

package Strings;

public class StringMethods {
    static void main(String[] args) {
        String name = "          Mohd Sameer,              ";
        System.out.println(name.length());
        System.out.println(name.charAt(1));
        System.out.println(name.toLowerCase());
        System.out.println(name.toUpperCase());
        System.out.println(name.trim());
        System.out.println(name.contains("@"));
        System.out.println(name.startsWith("Mohd"));
        System.out.println(name.indexOf("S"));
        System.out.println(name.substring(0,9));
        System.out.println(name.replace("Mohd", "Md"));
        System.out.println(name.split(","));
    }
}

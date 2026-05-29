package Strings.programs;

public class Main {
    public static void main(String[] args) {
        String stringOne = "Mohd Sameer";
        String stringTwo = "Mohd Sameer";
        Anagrams Anagrams = new Anagrams(stringOne, stringTwo);
        System.out.println(Anagrams.AnagramCheck());
    }
}
package Strings.programs;

public class RemoveAllSpaces {
    public static void main(String[] args) {
        String sentence = "Lorem Ipsum is simply dummy";
        String removeSpaces = sentence.replaceAll(" ", "");
        System.out.println(removeSpaces);
    }
}

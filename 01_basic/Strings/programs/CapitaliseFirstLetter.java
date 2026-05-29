package Strings.programs;

public class CapitaliseFirstLetter {
    public static void main(String[] args) {
        StringBuilder finalOutput = new StringBuilder();
        String sentence = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since 1966, when designers at Letraset and James Mosley, the librarian at St Bride Printing Library, took a 1914 Cicero translation and scrambled it to make dummy text for Letraset's Body Type sheets. It has survived not only many decades, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised thanks to these sheets and more recently with desktop publishing software including versions of Lorem Ipsum.";
        String[] splitSentence = sentence.trim().split(" ");

        for(int i =0; i < splitSentence.length; i++){
            String firstLetterCapital = splitSentence[i].substring(0, 1).toUpperCase() + splitSentence[i].substring(1);
            finalOutput.append(firstLetterCapital+ " ");
        }
        System.out.println(finalOutput);
    }
}

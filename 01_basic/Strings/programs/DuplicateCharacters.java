package Strings.programs;

public class DuplicateCharacters {
    String string;
    StringBuilder duplicateString;

    DuplicateCharacters(String string){
        this.string = string;
        duplicateString = new StringBuilder();
    }

    public void isduplicateCharacters(){
        for(int i = 0; i < string.length() -1; i++){
            if(string.charAt(i) == string.charAt(i+1)){
                duplicateString.append(string.charAt(i));
            }
        }
        System.out.println("Duplicate adjacent characters: " + duplicateString.toString());
    }
}

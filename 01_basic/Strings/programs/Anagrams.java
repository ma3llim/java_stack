package Strings.programs;

import java.util.Arrays;

public class Anagrams {
    String stringOne;
    String stringTwo;

    Anagrams(String stringOne, String stringTwo){
        this.stringOne = stringOne;
        this.stringTwo = stringTwo;
    }

    public Boolean AnagramCheck(){
        if(stringOne.length() != stringTwo.length()){
            return false;
        }
        char[] stringCharsOne = stringOne.toCharArray();
        char[] stringCharsTwo = stringTwo.toCharArray();
        Arrays.sort(stringCharsOne);
        Arrays.sort(stringCharsTwo);

        return Arrays.equals(stringCharsOne, stringCharsTwo);
    }
}

package Strings.programs;

import java.util.HashMap;

public class CountVowelsConsonants {
    String string;

    CountVowelsConsonants(String string){
        this.string = string;
    }

    public void isCountVowelsConsonants(){
        HashMap<String, Integer> letterCounters = new HashMap<>();

        int vowelCount = 0;
        int consonantCount = 0;
        String str = string.toLowerCase();

        for(int i=0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(Character.isLetter(ch)){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    vowelCount++;
                }else {
                    consonantCount++;
                }
            }
        }
        letterCounters.put("Vowels", vowelCount);
        letterCounters.put("Consonants", consonantCount);

        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);
        System.out.println("Count map: " + letterCounters);
    }
}

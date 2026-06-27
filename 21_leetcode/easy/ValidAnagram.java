package easy;

import java.util.Arrays;

public class ValidAnagram {
    boolean isAnagramBruteForce(String s, String t) {
        if(s.length() != t.length()) return false;

        boolean[] used = new boolean[t.length()];

        for( int i=0;i<s.length();i++){
            boolean found = false;
            for(int j=0;j<t.length();j++){
                if(!used[j] && s.charAt(i) == t.charAt(j)){
                    used[j] = true;
                    found = true;
                    break;
                }
            }

            if(!found) return false;
        }
        return true;
    }
    public boolean isAnagramBetterApproach(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagramBetterApproach("anagram", "nagaram"));
        System.out.println(validAnagram.isAnagramBetterApproach("rat", "car"));
    }
}


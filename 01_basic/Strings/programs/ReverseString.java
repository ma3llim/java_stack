package Strings.programs;

public class ReverseString {
    String name;

    ReverseString(String name){
        this.name = name;
    }

    public String ReverseStringWithStringBuilder(){
        return new StringBuilder(name).reverse().toString();
    }

    public String ReverseStringWithForLoop(){
        String outputString = "";
        for(int i = name.length() -1; i >= 0 ; i--){
            outputString += name.charAt(i);
        }
        return outputString;
    }

    public String ReverseStringWithTwoPointer(){
        char[] chars = name.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }
}
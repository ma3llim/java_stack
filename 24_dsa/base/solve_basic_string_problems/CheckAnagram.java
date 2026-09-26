package base.solve_basic_string_problems;

public class CheckAnagram {
    public static void main(String[] args) {
        String first = "listen";
        String second = "silent";
        char[] charFirst = first.toCharArray();
        char[] charSecond = second.toCharArray();
        boolean isAnagram = true;

        if (charFirst.length != charSecond.length) {
            isAnagram = false;
        } else {
            for (int i = 0; i < charFirst.length; i++) {
                int firstCount = 0;
                int secondCount = 0;

                for (int j = 0; j < charFirst.length; j++) {
                    if (charFirst[i] == charFirst[j]) {
                        firstCount++;
                    }
                }

                for (int j = 0; j < charSecond.length; j++) {
                    if (charFirst[i] == charSecond[j]) {
                        secondCount++;
                    }
                }

                if (firstCount != secondCount) {
                    isAnagram = false;
                    break;
                }
            }

        }

        if (isAnagram) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }
    }
}

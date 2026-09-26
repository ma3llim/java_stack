package base.solve_basic_string_problems;

public class FindDuplicateCharacters {
    public static void main(String[] args) {
        String name = "programming";
        char[] charName = name.toCharArray();

        for (int i = 0; i < charName.length; i++) {
            int counter = 0;

            for (int j = 0; j < charName.length; j++) {
                if (charName[i] == charName[j]) {
                    counter++;
                }
            }

            boolean alreadyPrinted = false;

            for (int j = 0; j < i; j++) {
                if (charName[i] == charName[j]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (counter > 1 && !alreadyPrinted) {
                System.out.println(charName[i]);
            }
        }
    }
}

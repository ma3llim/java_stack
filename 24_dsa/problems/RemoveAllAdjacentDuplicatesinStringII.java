package problems;

public class RemoveAllAdjacentDuplicatesinStringII {
    public static String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        boolean removed = true;

        while (removed) {
            removed = false;
            for (int i = 0; i <= sb.length(); i++) {
                int count = 1;

                for (int j = i + 1; j < sb.length(); j++) {
                    if (sb.charAt(i) == sb.charAt(j)) {
                        count++;
                    } else {
                        break;
                    }
                }

                if (count >= k) {
                    sb.delete(i, i + k);
                    removed = true;
                    break;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd", 2));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }
}

package problems;

public class MaximumNumberofBalloons {
    public static int maxNumberOfBalloons(String text) {
        StringBuilder sb = new StringBuilder(text);
        String target = "ballon";
        int count = 0;

        while (true) {
            boolean found = true;
            for (char ch : target.toCharArray()) {
                int index = sb.indexOf(String.valueOf(ch));

                if (index == -1) {
                    found = false;
                    break;
                }

                sb.deleteCharAt(index);
            }

            if (!found) {
                break;
            }

            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("leetcode"));
    }
}

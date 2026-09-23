public class MinimumElement {
    public static void main(String args[]) {
        int[] arrs = { 10, 20, 300, 400, 5 };
        int min = arrs[0];

        for (int i = 1; i < arrs.length; i++) {
            if (min >= arrs[i]) {
                min = arrs[i];
            }
        }

        System.out.println(min);
    }
}

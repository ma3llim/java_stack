public class LargestElement {
    public static void main(String args[]) {
        int[] arrs = { 10, 20, 300, 400, 50, 900 };
        int max = arrs[0];

        for (int i = 1; i < arrs.length; i++) {
            if (max <= arrs[i]) {
                max = arrs[i];
            }
        }

        System.out.println(max);
    }
}

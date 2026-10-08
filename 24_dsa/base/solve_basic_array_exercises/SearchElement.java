public class SearchElement {
    public static void main(String args[]) {
        int[] arrs = { 10, 20, 30, 40, 50 };
        int target = 30;

        for (int i = 0; i < arrs.length; i++) {
            if (target == arrs[i]) {
                System.out.println(i);
            }
        }
    }
}

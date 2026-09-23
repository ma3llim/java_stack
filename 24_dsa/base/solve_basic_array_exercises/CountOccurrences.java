public class CountOccurrences {
    public static void main(String argsp[]) {
        int[] arr = { 10, 20, 10, 30, 10, 40 };
        int target = 10;
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}

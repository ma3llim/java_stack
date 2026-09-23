public class SecondLargestElement {
    public static void main(String args[]) {
        int[] arrs = { 10, 50, 40, 45 };
        int largest = arrs[0];
        int secondLargest = arrs[0];

        for (int i = 1; i < arrs.length; i++) {
            if (arrs[i] > largest) {
                secondLargest = largest;
                largest = arrs[i];
            } else if (arrs[i] > secondLargest) {
                secondLargest = arrs[i];
            }
        }

        System.out.println(largest);
        System.out.println(secondLargest);
    }
}

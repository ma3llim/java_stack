public class CountEvenAndOdd {
    public static void main(String[] args) {
        int[] arr = { 10, 21, 32, 45, 50, 63 };
        int even = 0, odd = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println(even);
        System.out.println(odd);
    }
}

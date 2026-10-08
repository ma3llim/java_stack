public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        int[] reverseArr = new int[arr.length];
        int index = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            reverseArr[index] = arr[i];
            index++;
        }

        for (int i : reverseArr) {
            System.out.println(i);
        }
    }
}

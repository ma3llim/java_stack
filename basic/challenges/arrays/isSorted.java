package arrays;

public class isSorted {
    public static void main(String[] args) {
        int[] arrayNum = { 1, 2, 3, 4, 6, 7, 8, 9, 10 };
        boolean sorted = true;
        for (int i = 0; i < arrayNum.length - 1; i++) {
            if (arrayNum[i] > arrayNum[i + 1]) {
                sorted = false;
            }
        }

        System.out.println(
                sorted ? "The Given Array is Sorted" : "The Given Array is NOT Sorted");

    }

}

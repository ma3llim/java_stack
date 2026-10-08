package search.ImplementLinearSearch;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = { 10, 25, 30, 45, 50 };
        int target1 = 30;
        int target2 = 100;

        System.out.println(linearSearch(arr1, target1));
        System.out.println("--------------");
        System.out.println(linearSearch(arr1, target2));

    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }
}

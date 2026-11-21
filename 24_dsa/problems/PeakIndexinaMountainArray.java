package problems;

public class PeakIndexinaMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] { 0, 1, 0 }));
        System.out.println(peakIndexInMountainArray(new int[] { 0, 2, 1, 0 }));
        System.out.println(peakIndexInMountainArray(new int[] { 0, 10, 5, 2 }));
        System.out.println(peakIndexInMountainArray(new int[] { 0, 10, 50, 2 }));
        System.out.println(peakIndexInMountainArray(new int[] { 0, 10, 50, 70, 2 }));
    }
}

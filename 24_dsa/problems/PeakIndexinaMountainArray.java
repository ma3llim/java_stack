package problems;

public class PeakIndexinaMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[answer]) {
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] { 0, 1, 0 }));
        System.out.println(peakIndexInMountainArray(new int[] { 0, 2, 1, 0 }));
        System.out.println(peakIndexInMountainArray(new int[] { 0, 10, 5, 2 }));
        System.out.println(peakIndexInMountainArray(new int[] { 0, 10, 50, 2 }));
        System.out.println(peakIndexInMountainArray(new int[] { 0, 10, 50, 2, 70 }));
    }
}

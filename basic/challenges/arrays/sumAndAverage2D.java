package arrays;

public class sumAndAverage2D {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int sum = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
                count++;
            }
        }
        double average = (double) sum / count;

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
    }
}
public class TwoDimensionalArray {
    public static void main(String[] args) {
        // Declaration
        // int[][] numArr = new int[2][4];
        int[][] numArr2 = { { 1, 2 }, { 2, 3 }, { 5, 6 }, { 7, 8, 9 } };

        int i = 0;
        while (i < numArr2.length) {
            int j = 0;
            while (j < numArr2[i].length) {
                System.out.print(numArr2[i][j] + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}

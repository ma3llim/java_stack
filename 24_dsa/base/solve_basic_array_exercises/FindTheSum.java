class FindTheSum {
    public static void main(String args[]) {
        int sum = 0;
        int[] arrs = { 10, 20, 30, 40, 50 };

        for (int i = 0; i < arrs.length; i++) {
            sum += arrs[i];
        }

        System.out.println(sum);
    }
}
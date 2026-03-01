public class OddNumber {
    public static void main(String[] args){
        int result = oddNumberSum(10);
        System.out.println("Sum of the Odd Number" + result);
    }

    public static int oddNumberSum(int lastNumber) {
        int totalSum = 0;
        for(int i = 0; i <= lastNumber;  i++){
            if(i % 2 !=0){
                System.out.print(i);
                totalSum += i;
            }
        }

        return totalSum;
    }
}
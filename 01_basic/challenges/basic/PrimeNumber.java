package challenges.basic;

public class PrimeNumber {
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if ((num % 2) == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
           if(i%2==0) {
               return false;
           };
        }
        return  true;
    }

    public static void main(String[] args){
        Boolean result = isPrime(7);
        System.out.println(result);
    }
}
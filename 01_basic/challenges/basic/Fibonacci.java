package challenges.basic;

public class Fibonacci {
    public static void printFibonacci(int n){
        if(n<=0){
            System.out.println("Please Enter a positive number");
            return;
        }
        int curr=0;
        int prev=1;
        System.out.println("Fibonacci Series First Number: " + n);
        for(int i=0; i<=n; i++){
            System.out.print(prev);
            if(i<n){
                System.out.print(", ");
            }
            int next = prev+curr;
            prev = curr;
            curr = next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        printFibonacci(8);
    }
}
